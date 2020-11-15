package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Adapters.PaymentAdapter;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Pattern;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.PatternAPI;

public class InfoPatternFragment extends MyFragment {
    Pattern pattern;

    TextView name;
    TextView type;
    TextView averangeAmount;
    TextView monthAmount;
    RecyclerView patternTransactionsRecycler;
    ImageButton editPattern;

    public InfoPatternFragment(String patternId, String Title) {
        this.Title = Title;
        pattern = new Pattern();
        pattern.setId(UUID.fromString(patternId));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.info_pattern, container, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.Server_Base_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PatternAPI patternAPI = retrofit.create(PatternAPI.class);
        Call<Pattern> call = patternAPI.getPattern(pattern.getId().toString());
        call.enqueue(new Callback<Pattern>() {
            @Override
            public void onResponse(Call<Pattern> call, Response<Pattern> response) {
                Log.d("RETROFIT_INFO", response.body().toString());
                boolean suc = response.isSuccessful();
                pattern = response.body();
                bindData();
            }

            @Override
            public void onFailure(Call<Pattern> call, Throwable t) {

            }
        });

        name = v.findViewById(R.id.patternName);
        type = v.findViewById(R.id.patternType);
        averangeAmount = v.findViewById(R.id.patternAverageAmount);
        monthAmount = v.findViewById(R.id.patternMonthAmount);
        patternTransactionsRecycler = v.findViewById(R.id.patternsTransactionsRecycler);
        editPattern = v.findViewById(R.id.editPattern);

        return v;
    }

    private void bindData() {
        name.setText(pattern.getPatternName());
        type.setText(pattern.getPatternType().toString());
        averangeAmount.setText(pattern.getAverageTransAmount().toString());
        monthAmount.setText(pattern.getAllAmount().toString());
        patternTransactionsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        patternTransactionsRecycler.setAdapter(new PaymentAdapter(pattern.getTransactions(),
                null, ((MainActivity) getActivity())));
        editPattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).changeFragment(new AddPattern(pattern, "Edit pattern"));
            }
        });
    }
}
