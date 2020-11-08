package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.opkeeper.R;

public class Main_Goal_Fragment extends MyFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_goal_fragment, container, false);

        AppCompatSeekBar seekBarObligatoryProcent = v.findViewById(R.id.seekBarObligatoryProcent);
        AppCompatSeekBar seekBarLeisureProcent = v.findViewById(R.id.seekBarLeisureProcent);
        AppCompatSeekBar seekBarСapitalProcent = v.findViewById(R.id.seekBarСapitalProcent);
        AppCompatSeekBar seekBarBudgetProcent = v.findViewById(R.id.seekBarBudgetProcent);

        RecyclerView budgetLeaksRecycler = v.findViewById(R.id.budgetLeaksRecycler);
        RecyclerView patternsRecycler = v.findViewById(R.id.patternsRecycler);

        seekBarObligatoryProcent.setProgress(35);
        seekBarLeisureProcent.setProgress(49);
        seekBarСapitalProcent.setProgress(7);

        
        seekBarBudgetProcent.setProgress();

        return v;
    }
}
