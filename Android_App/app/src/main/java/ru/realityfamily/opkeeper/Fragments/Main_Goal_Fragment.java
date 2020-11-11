package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Adapters.PaymentAdapter;
import ru.realityfamily.opkeeper.Models.Pattern;
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

        seekBarObligatoryProcent.setProgress(35);
        seekBarObligatoryProcent.setThumb(null);
        seekBarLeisureProcent.setProgress(49);
        seekBarLeisureProcent.setThumb(null);
        seekBarСapitalProcent.setProgress(7);
        seekBarСapitalProcent.setThumb(null);

        seekBarBudgetProcent.setThumb(null);
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
        PatternAPI patternAPI = retrofit.create(PatternAPI.class);
        Call<List<Pattern>> call1 = patternAPI.getPatterns();
        call1.enqueue(new Callback<List<Pattern>>() {
            @Override
            public void onResponse(Call<List<Pattern>> call, Response<List<Pattern>> response) {
                budgetLeaksRecycler.setAdapter(new PaymentAdapter(null, response.body()));
            }

            @Override
            public void onFailure(Call<List<Pattern>> call, Throwable t) {
                Log.e("RETROFIT_ERROR", call.request().url().toString() + "\t Headers: "
                        + call.request().headers().toString() + "\t" + t.getMessage());
            }
        });

        return v;
    }
}
