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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.realityfamily.opkeeper.Adapters.PaymentAdapter;
import ru.realityfamily.opkeeper.Models.Challenge;
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.R;

public class ChallengeFragment extends MyFragment {
    Challenge challenge;
    View thumbView;

    public ChallengeFragment(Challenge challenge, String title) {
        this.challenge = challenge;
        this.Title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.challenge_fragment, container, false);

        TextView challengeName = v.findViewById(R.id.challengeName);
        AppCompatSeekBar seekBarChallengeProcent = v.findViewById(R.id.seekBarChallengeProcent);
        TextView challengeBalance = v.findViewById(R.id.challengeBalance);
        TextView challengeAmount = v.findViewById(R.id.challengeAmount);
        RecyclerView challengePatternsRecycler = v.findViewById(R.id.challengePatternsRecycler);
        Button shareChallenge = v.findViewById(R.id.shareChallenge);

        challengeName.setText(challenge.getName());

        thumbView = LayoutInflater.from(getActivity()).inflate(R.layout.seek_thumb, null, false);
        seekBarChallengeProcent.setThumb(getThumb((int) (double) (challenge.getGoal().getBalance() * 100 / challenge.getGoal().getProgress())));
        seekBarChallengeProcent.setEnabled(false);

        seekBarChallengeProcent.setProgress((int) (double) (challenge.getGoal().getBalance() * 100 / challenge.getGoal().getProgress()));
        challengeBalance.setText(Double.toString(challenge.getGoal().getBalance()));
        challengeAmount.setText(Double.toString(challenge.getGoal().getProgress()));

        challengePatternsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        challengePatternsRecycler.setHasFixedSize(true);
        challengePatternsRecycler.setAdapter(new PaymentAdapter(null, challenge.getGoal().getPatterns()));

        shareChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
