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

import ru.realityfamily.opkeeper.Adapters.DashboardAdapter;
import ru.realityfamily.opkeeper.R;

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

        List<String> elements = new ArrayList<>();
        elements.add("50/30/20");
        elements.add("Travel to Bali");
        elements.add("Travel to Bali");

        goalsRecycler = v.findViewById(R.id.RecyclerGoals);
        challengesRecycler = v.findViewById(R.id.RecyclerChallenges);
        fbottomSheet = v.findViewById(R.id.bottomSheetContainer);
        addGoal = v.findViewById(R.id.addGoal);
        addChallenge = v.findViewById(R.id.addChallenge);

        goalsRecycler.setHasFixedSize(true);
        goalsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        goalsRecycler.setAdapter(new DashboardAdapter(elements));

        elements = new ArrayList<>();
        elements.add("Keep calm and spend less");
        elements.add("Keep calm and spend less");
        elements.add("Keep calm and spend less");

        challengesRecycler.setHasFixedSize(true);
        challengesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        challengesRecycler.setAdapter(new DashboardAdapter(elements));

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
