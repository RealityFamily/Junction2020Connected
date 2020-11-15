package ru.realityfamily.opkeeper.Fragments;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.opkeeper.Adapters.PaymentAdapter;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.R;

public class GoalFragment extends MyFragment {
    Goal goal;
    View thumbView;

    public GoalFragment(Goal goal, String title) {
        this.goal = (goal != null ? goal : new Goal());
        this.Title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.goal_fragment, container, false);

        TextView name = v.findViewById(R.id.goalName);
        TextView description = v.findViewById(R.id.goalDescription);
        TextView procent = v.findViewById(R.id.goalProcentAmount);
        AppCompatSeekBar seekBarProgress = v.findViewById(R.id.seekBarGoalProcent);
        Button shareBtn = v.findViewById(R.id.shareGoal);
        RecyclerView recyclerView = v.findViewById(R.id.goalPattenrsRecycler);

        thumbView = LayoutInflater.from(getActivity()).inflate(R.layout.seek_thumb, null, false);

        name.setText(goal.getName());
        description.setText(goal.getDescription());
        procent.setText(goal.getWeightInDepositoryPipe20() + "%");
        seekBarProgress.setThumb(getThumb((int) (double) goal.getProgress()));
        seekBarProgress.setProgress((int) (double) goal.getProgress());
        seekBarProgress.setEnabled(false);


        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PaymentAdapter(null, goal.getPatterns(),
                ((MainActivity) getActivity())));

        return v;
    }

    public Drawable getThumb(int progress) {
        ((TextView) thumbView.findViewById(R.id.seekBarProcess)).setText(progress + "%");

        thumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Bitmap bitmap = Bitmap.createBitmap(thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        thumbView.layout(0, 0, thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight());
        thumbView.draw(canvas);

        return new BitmapDrawable(getResources(), bitmap);
    }
}
