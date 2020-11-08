package ru.realityfamily.opkeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import ru.realityfamily.opkeeper.Fragments.DashboardFragment;
import ru.realityfamily.opkeeper.Fragments.MyFragment;

public class MainActivity extends AppCompatActivity {
    TextView toolbarTitle;
    ImageButton appBarBackButton;
    MyFragment backFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarTitle = findViewById(R.id.toolbarTitle);
        appBarBackButton = findViewById(R.id.appBarBackButton);

        appBarBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameContainer, backFragment).commit();
                    toolbarTitle.setText(backFragment.Title);
                }
            }
        });

        DashboardFragment df = new DashboardFragment("Dashboard");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, df).commit();
        toolbarTitle.setText(df.Title);
    }

    public void changeFragment(MyFragment fragment, String title, MyFragment oldFragment) {
        backFragment = oldFragment;

        toolbarTitle.setText(title);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, fragment).commit();
    }
}