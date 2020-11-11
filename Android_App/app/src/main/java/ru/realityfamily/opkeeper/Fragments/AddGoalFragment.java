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
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.Fragment;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.R;
import ru.realityfamily.opkeeper.Requests.GoalsAPI;

public class AddGoalFragment extends Fragment {
    View thumbView;

    EditText name;
    EditText description;
    EditText amount;
    AppCompatSeekBar procent;

    DashboardFragment dashboardFragment;

    public AddGoalFragment(DashboardFragment dashboardFragment) {
        this.dashboardFragment = dashboardFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_goal_fragment, container, false);

        procent = v.findViewById(R.id.newSeekBarProcent);
        name = v.findViewById(R.id.newGoalName);
        description = v.findViewById(R.id.newGoalDescription);
        amount = v.findViewById(R.id.newGoalAmount);

        procent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setThumb(getThumb(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        procent.setProgress(0);
        thumbView = LayoutInflater.from(getActivity()).inflate(R.layout.seek_thumb, null, false);

        Button btn = v.findViewById(R.id.sendGoal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goal newGoal = new Goal();

                newGoal.setName(name.getText().toString());
                newGoal.setDescription(description.getText().toString());
                newGoal.setBalance(Double.parseDouble(amount.getText().toString()));
                newGoal.setWeightInDepositoryPipe20((double) procent.getProgress());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.Server_Base_URL))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                GoalsAPI goalsAPI = retrofit.create(GoalsAPI.class);
                Call<ResponseBody> call = goalsAPI.postGoal(newGoal);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            dashboardFragment.refreshRecyclerViewData();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
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
