package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Adapters.DashboardAdapter;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.ChallengeAPI;
import ru.realityfamily.opkeeper.Requests.GoalsAPI;

public class DashboardFragment extends MyFragment {

    RecyclerView goalsRecycler;
    RecyclerView challengesRecycler;
    FrameLayout fbottomSheet;
    ImageButton addGoal;
    ImageButton addChallenge;

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

        goalsRecycler.setHasFixedSize(true);
        goalsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.world_server))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);
        Call<List<DashboardAdapter.SmallInfo>> call = goalsAPI.getGoals();
        call.enqueue(new Callback<List<DashboardAdapter.SmallInfo>>() {
            @Override
            public void onResponse(Call<List<DashboardAdapter.SmallInfo>> call, Response<List<DashboardAdapter.SmallInfo>> response) {
                goalsRecycler.setAdapter(new DashboardAdapter(response.body(), DashboardAdapter.TypeElementInfo.Goal, (MainActivity) getActivity()));
            }

            @Override
            public void onFailure(Call<List<DashboardAdapter.SmallInfo>> call, Throwable t) {

            }
        });

        challengesRecycler.setHasFixedSize(true);
        challengesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        ChallengeAPI challengeAPI = retrofit.create(ChallengeAPI.class);
        Call<List<DashboardAdapter.SmallInfo>> call1 = challengeAPI.getChallenges();
        call1.enqueue(new Callback<List<DashboardAdapter.SmallInfo>>() {
            @Override
            public void onResponse(Call<List<DashboardAdapter.SmallInfo>> call, Response<List<DashboardAdapter.SmallInfo>> response) {
                challengesRecycler.setAdapter(new DashboardAdapter(response.body(), DashboardAdapter.TypeElementInfo.Challenge, (MainActivity) getActivity()));
            }

            @Override
            public void onFailure(Call<List<DashboardAdapter.SmallInfo>> call, Throwable t) {

            }
        });

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(fbottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehavior.setHideable(true);

        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bottomSheetContainer, new AddGoalFragment()).commit();
            }
        });
        addChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bottomSheetContainer, new AddChallengeFragment()).commit();
            }
        });

        return v;
    }
}
