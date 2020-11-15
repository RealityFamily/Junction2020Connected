package ru.realityfamily.opkeeper.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.opkeeper.Adapters.PaymentAdapter;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Pattern;
import ru.realityfamily.opkeeper.R;

public class AddPattern extends MyFragment {

    Pattern pattern;
    boolean selected = false;

    public AddPattern(Pattern pattern, String Title) {
        this.pattern = pattern;
        this.Title = Title;
    }

    public AddPattern (String Title) {
        this.Title = Title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_pattern, container, false);

        EditText addPatternName = v.findViewById(R.id.addPatternName);
        Button addPatternObligatory = v.findViewById(R.id.addPatternObligatory);
        Button addPatterLeisure = v.findViewById(R.id.addPatterLeisure);
        RecyclerView addPatternsTransactionsRecycler = v.findViewById(R.id.addPatternsTransactionsRecycler);
        Button addPatternCommit = v.findViewById(R.id.addPatternCommit);

        if (pattern != null) {
            addPatternName.setText(pattern.getPatternName());
            switch (pattern.getPatternType()){
                case Obligatory:
                    addPatternObligatory.setTextColor(getContext().getColor(R.color.darkOrange));
                    addPatternObligatory.setBackgroundResource(R.drawable.active_btn);
                    selected = true;
                    break;
                case Leisure:
                    addPatterLeisure.setTextColor(getContext().getColor(R.color.darkOrange));
                    addPatterLeisure.setBackgroundResource(R.drawable.active_btn);
                    selected = true;
                    break;
            }
            addPatternsTransactionsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            addPatternsTransactionsRecycler.setAdapter(new PaymentAdapter(pattern.getTransactions(), null, (MainActivity) getActivity()));

            addPatternCommit.setText("Change");
            addPatternCommit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selected) {
                        pattern.setPatternName(addPatternName.getText().toString());

                        // post to change data
                    }
                }
            });
        } else {
            addPatternCommit.setText("Add");
            addPatternCommit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selected) {
                        pattern.setPatternName(addPatternName.getText().toString());

                        // post to add data
                    }
                }
            });
        }

        addPatternObligatory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPatternObligatory.setTextColor(getContext().getColor(R.color.darkOrange));
                addPatternObligatory.setBackgroundResource(R.drawable.active_btn);

                addPatterLeisure.setTextColor(getContext().getColor(R.color.TextColor));
                addPatterLeisure.setBackgroundResource(R.drawable.not_active_btn);

                if (pattern == null) {
                    pattern = new Pattern();
                }
                pattern.setPatternType(Pattern.PatternTypeEnum.Obligatory);
                selected = true;
            }
        });
        addPatterLeisure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPatterLeisure.setTextColor(getContext().getColor(R.color.darkOrange));
                addPatterLeisure.setBackgroundResource(R.drawable.active_btn);

                addPatternObligatory.setTextColor(getContext().getColor(R.color.TextColor));
                addPatternObligatory.setBackgroundResource(R.drawable.not_active_btn);

                if (pattern == null) {
                    pattern = new Pattern();
                }
                pattern.setPatternType(Pattern.PatternTypeEnum.Leisure);
                selected = true;
            }
        });

        return v;
    }
}
