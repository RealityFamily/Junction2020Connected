package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Adapters.PaymentAdapter;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Pattern;
import ru.realityfamily.opkeeper.Models.SmallInfo;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.PatternAPI;
import ru.realityfamily.opkeeper.Requests.TransactionsAPI;

public class Main_Goal_Fragment extends MyFragment {

    public Main_Goal_Fragment(String Title) {
        this.Title = Title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_goal_fragment, container, false);

        AppCompatSeekBar seekBarObligatoryProcent = v.findViewById(R.id.seekBarObligatoryProcent);
        AppCompatSeekBar seekBarLeisureProcent = v.findViewById(R.id.seekBarLeisureProcent);
        AppCompatSeekBar seekBarСapitalProcent = v.findViewById(R.id.seekBarCapacityProcent);
        AppCompatSeekBar seekBarBudgetProcent = v.findViewById(R.id.seekBarBudgetProcent);

        RecyclerView budgetLeaksRecycler = v.findViewById(R.id.budgetLeaksRecycler);
        RecyclerView patternsRecycler = v.findViewById(R.id.patternsRecycler);

        ImageButton addPatternInfo = v.findViewById(R.id.addPatternInfo);

        seekBarObligatoryProcent.setProgress(35);
        seekBarObligatoryProcent.setThumb(null);
        seekBarObligatoryProcent.setEnabled(false);
        seekBarLeisureProcent.setProgress(49);
        seekBarLeisureProcent.setThumb(null);
        seekBarLeisureProcent.setEnabled(false);
        seekBarСapitalProcent.setProgress(7);
        seekBarСapitalProcent.setThumb(null);
        seekBarСapitalProcent.setEnabled(false);

        seekBarBudgetProcent.setThumb(null);
        seekBarBudgetProcent.setEnabled(false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.Server_Base_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransactionsAPI transactionsAPI = retrofit.create(TransactionsAPI.class);
        Call<Double> call = transactionsAPI.getDebCredStatus();
        call.enqueue(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                if (response.isSuccessful()) {
                    seekBarBudgetProcent.setProgress((int) (response.body() * 100));
                }
            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {
                seekBarBudgetProcent.setProgress(50);
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });

        budgetLeaksRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        patternsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        PatternAPI patternAPI = retrofit.create(PatternAPI.class);
        Call<List<Pattern>> call1 = patternAPI.getPatterns();
        call1.enqueue(new Callback<List<Pattern>>() {
            @Override
            public void onResponse(Call<List<Pattern>> call, Response<List<Pattern>> response) {
                List<Pattern> budget_leak_elements = new ArrayList<>();
                List<Pattern> patterns_elements = new ArrayList<>();

                for (Pattern p : response.body()) {
                    switch (p.getPatternType()) {
                        case Obligatory:
                            patterns_elements.add(p);
                            break;
                        case Leisure:
                            budget_leak_elements.add(p);
                            break;
                    }
                }
                budgetLeaksRecycler.setAdapter(new PaymentAdapter(null,
                        budget_leak_elements, ((MainActivity) getActivity())));
                patternsRecycler.setAdapter(new PaymentAdapter(null,
                        patterns_elements, ((MainActivity) getActivity())));

            }

            @Override
            public void onFailure(Call<List<Pattern>> call, Throwable t) {
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });

        addPatternInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new AddPattern("Add new pattern"));
            }
        });

        return v;
    }
}
