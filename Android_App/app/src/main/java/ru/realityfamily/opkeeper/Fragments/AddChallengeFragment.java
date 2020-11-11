package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Models.Challenge;
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.ChallengeAPI;
import ru.realityfamily.opkeeper.Requests.GoalsAPI;

public class AddChallengeFragment extends Fragment {
    DashboardFragment dashboardFragment;

    public AddChallengeFragment(DashboardFragment dashboardFragment) {
        this.dashboardFragment = dashboardFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_challenger_fragment, container, false);

        Button btn = v.findViewById(R.id.sendChallenge);
        EditText name = v.findViewById(R.id.newChallengeName);
        EditText amount = v.findViewById(R.id.newChallengeAmount);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Challenge challenge = new Challenge();
                Goal goal = new Goal();

                challenge.setName(name.getText().toString());
                goal.setBalance(Double.parseDouble(amount.getText().toString()));
                challenge.setGoal(goal);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.Server_Base_URL))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ChallengeAPI challengeAPI = retrofit.create(ChallengeAPI.class);
                Call<ResponseBody> call = challengeAPI.postChallenge(challenge);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            dashboardFragment.refreshRecyclerViewData();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        return v;
    }
}
