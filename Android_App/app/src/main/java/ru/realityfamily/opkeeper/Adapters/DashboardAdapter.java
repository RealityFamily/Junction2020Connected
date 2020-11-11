package ru.realityfamily.opkeeper.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Fragments.ChallengeFragment;
import ru.realityfamily.opkeeper.Fragments.DashboardFragment;
import ru.realityfamily.opkeeper.Fragments.GoalFragment;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Challenge;
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.ChallengeAPI;
import ru.realityfamily.opkeeper.Requests.GoalsAPI;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {
    public enum TypeElementInfo{
        Goal,
        Challenge
    }

    List<SmallInfo> goalElements = new ArrayList<>();
    List<SmallInfo> challengeElements = new ArrayList<>();
    TypeElementInfo typeElement;
    MainActivity activity;

    public DashboardAdapter(TypeElementInfo typeElement, MainActivity activity) {
        DashboardAdapter adapter = this;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(activity.getString(R.string.Server_Base_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);
        Call<List<DashboardAdapter.SmallInfo>> call = goalsAPI.getGoals();
        call.enqueue(new Callback<List<SmallInfo>>() {
            @Override
            public void onResponse(Call<List<DashboardAdapter.SmallInfo>> call, Response<List<DashboardAdapter.SmallInfo>> response) {
                List<DashboardAdapter.SmallInfo> elements = new ArrayList<>();
                for (DashboardAdapter.SmallInfo element : response.body()) {
                    if (!element.getName().equals("50/30/20")) {
                        goalElements.add(element);
                    }
                }
                NotifyAllElements();
            }
            @Override
            public void onFailure(Call<List<SmallInfo>> call, Throwable t) {
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });


        ChallengeAPI challengeAPI = retrofit.create(ChallengeAPI.class);
        Call<List<DashboardAdapter.SmallInfo>> call1 = challengeAPI.getChallenges();
        call1.enqueue(new Callback<List<DashboardAdapter.SmallInfo>>() {
            @Override
            public void onResponse(Call<List<DashboardAdapter.SmallInfo>> call, Response<List<DashboardAdapter.SmallInfo>> response) {
                challengeElements = response.body();
                NotifyAllElements();
            }
            @Override
            public void onFailure(Call<List<DashboardAdapter.SmallInfo>> call, Throwable t) {
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });

        this.typeElement = typeElement;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashboardViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_cardview_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(activity.getString(R.string.Server_Base_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        switch (typeElement) {

            case Goal:
                holder.elementTitle.setText(goalElements.get(position).name);
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);

                        String goalId = goalElements.get(position).id.toString();
                        Call<Goal> call = goalsAPI.getGoal(goalId);
                        call.enqueue(new Callback<Goal>() {
                            @Override
                            public void onResponse(Call<Goal> call, Response<Goal> response) {
                                Log.d("RETROFIT_INFO", Integer.toString(response.code()));

                                Goal temp = response.body();

                                activity.changeFragment(
                                        new GoalFragment(response.body(),"Goal"),
                                        new DashboardFragment("Dashboard")
                                );
                            }

                            @Override
                            public void onFailure(Call<Goal> call, Throwable t) {
                                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                                        + call.request().headers().toString() + "\t" + t.getMessage());
                            }
                        });
                    }
                });
                break;
            case Challenge:
                holder.elementTitle.setText(challengeElements.get(position).name);
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ChallengeAPI challengeAPI = retrofit.create(ChallengeAPI.class);

                        Call<Challenge> call = challengeAPI.getChallenge(challengeElements.get(position).id.toString());
                        call.enqueue(new Callback<Challenge>() {
                            @Override
                            public void onResponse(Call<Challenge> call, Response<Challenge> response) {
                                activity.changeFragment(
                                        new ChallengeFragment(response.body(), "Challenge"),
                                        new DashboardFragment("Dashboard"));
                            }

                            @Override
                            public void onFailure(Call<Challenge> call, Throwable t) {
                                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                                        + call.request().headers().toString() + "\t" + t.getMessage());
                            }
                        });
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        switch (typeElement) {
            case Goal:
                return goalElements.size();
            case Challenge:
                return challengeElements.size();
            default:
                return Math.min(goalElements.size(), challengeElements.size());
        }
    }

    class DashboardViewHolder extends RecyclerView.ViewHolder{

        TextView elementTitle;
        CardView cardView;

        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);

            elementTitle = itemView.findViewById(R.id.elementTitle);
            cardView = itemView.findViewById(R.id.dashboardCard);
        }
    }

    public static class SmallInfo {
        String name;
        UUID id;

        public SmallInfo(String name, UUID id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }
    }

    public void NotifyAllElements() {
        notifyDataSetChanged();
    }

    public ItemTouchHelper.SimpleCallback swipeCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(activity.getString(R.string.Server_Base_URL))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            switch (typeElement) {
                case Goal:
                    GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);
                    Call<ResponseBody> call = goalsAPI.deleteGoal(goalElements.get(position).getId());
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });

                    goalElements.remove(position);
                    break;
                case Challenge:
                    ChallengeAPI challengeAPI = retrofit.create(ChallengeAPI.class);
                    Call<ResponseBody> call1 = challengeAPI.deleteChallenge(challengeElements.get(position).getId());
                    call1.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });

                    challengeElements.remove(position);
                    break;
            }
        }
    };
}
