package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.TransactionsAPI;

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
        seekBarObligatoryProcent.setThumb(null);
        seekBarLeisureProcent.setProgress(49);
        seekBarLeisureProcent.setThumb(null);
        seekBarСapitalProcent.setProgress(7);
        seekBarСapitalProcent.setThumb(null);

        seekBarBudgetProcent.setThumb(null);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.world_server))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TransactionsAPI transactionsAPI = retrofit.create(TransactionsAPI.class);
        Call<Integer> call = transactionsAPI.getDebCredStatus();
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                seekBarBudgetProcent.setProgress(response.body());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });

        return v;
    }
}
