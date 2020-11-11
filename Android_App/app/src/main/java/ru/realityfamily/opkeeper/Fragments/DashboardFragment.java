package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Adapters.DashboardAdapter;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.ChallengeAPI;
import ru.realityfamily.opkeeper.Requests.GoalsAPI;

public class DashboardFragment extends MyFragment {

    CardView mainGoalCard;
    TextView mainGoalTitle;
    RecyclerView goalsRecycler;
    RecyclerView challengesRecycler;
    FrameLayout fbottomSheet;
    ImageButton addGoal;
    ImageButton addChallenge;

    BottomSheetBehavior bottomSheetBehavior;

    public DashboardFragment(String title) {
        Title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dashboard_fragment, container, false);

        goalsRecycler = v.findViewById(R.id.RecyclerGoals);
        challengesRecycler = v.findViewById(R.id.RecyclerChallenges);
        fbottomSheet = v.findViewById(R.id.bottomSheetContainer);
        addGoal = v.findViewById(R.id.addGoal);
        addChallenge = v.findViewById(R.id.addChallenge);
        mainGoalCard = v.findViewById(R.id.dashboardCard);
        mainGoalTitle = v.findViewById(R.id.elementTitle);

        goalsRecycler.setHasFixedSize(true);
        goalsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.Server_Base_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);
        Call<List<DashboardAdapter.SmallInfo>> call = goalsAPI.getGoals();
        call.enqueue(new Callback<List<DashboardAdapter.SmallInfo>>() {
            @Override
            public void onResponse(Call<List<DashboardAdapter.SmallInfo>> call, Response<List<DashboardAdapter.SmallInfo>> response) {
                for (DashboardAdapter.SmallInfo element : response.body()) {
                    if (element.getName().equals("50/30/20")) {
                        mainGoalTitle.setText(element.getName());
                        mainGoalCard.setOnClickListener(getListener(element.getName()));
                    }
                }

                DashboardAdapter adapter = new DashboardAdapter(DashboardAdapter.TypeElementInfo.Goal,
                        (MainActivity) getActivity());
                goalsRecycler.setAdapter(adapter);
                new ItemTouchHelper(adapter.swipeCallBack).attachToRecyclerView(goalsRecycler);
            }

            @Override
            public void onFailure(Call<List<DashboardAdapter.SmallInfo>> call, Throwable t) {
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });

        challengesRecycler.setHasFixedSize(true);
        challengesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        ChallengeAPI challengeAPI = retrofit.create(ChallengeAPI.class);
        Call<List<DashboardAdapter.SmallInfo>> call1 = challengeAPI.getChallenges();
        call1.enqueue(new Callback<List<DashboardAdapter.SmallInfo>>() {
            @Override
            public void onResponse(Call<List<DashboardAdapter.SmallInfo>> call, Response<List<DashboardAdapter.SmallInfo>> response) {
                DashboardAdapter adapter = new DashboardAdapter(DashboardAdapter.TypeElementInfo.Challenge,
                        (MainActivity) getActivity());
                challengesRecycler.setAdapter(adapter);
                new ItemTouchHelper(adapter.swipeCallBack).attachToRecyclerView(challengesRecycler);
            }

            @Override
            public void onFailure(Call<List<DashboardAdapter.SmallInfo>> call, Throwable t) {
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });

        bottomSheetBehavior = BottomSheetBehavior.from(fbottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setHideable(true);

        DashboardFragment dashboardFragment = this;

        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bottomSheetContainer, new AddGoalFragment(dashboardFragment)).commit();
            }
        });
        addChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bottomSheetContainer, new AddChallengeFragment(dashboardFragment)).commit();
            }
        });

        return v;
    }

    private View.OnClickListener getListener(String goalId) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.Server_Base_URL))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);

                Call<Goal> call = goalsAPI.getGoal(goalId);
                call.enqueue(new Callback<Goal>() {
                    @Override
                    public void onResponse(Call<Goal> call, Response<Goal> response) {
                        ((MainActivity) getActivity()).changeFragment(
                                new Main_Goal_Fragment(),
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
        };
    }

    public void refreshRecyclerViewData() {
        goalsRecycler.getAdapter().notifyDataSetChanged();
        challengesRecycler.getAdapter().notifyDataSetChanged();
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

    }
}
