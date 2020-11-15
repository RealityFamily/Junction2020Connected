package ru.realityfamily.opkeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

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
                FragmentManager fm = getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 1) {
                    fm.popBackStack();
                    String Title = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 2).getName();
                    toolbarTitle.setText(Title);
                }
            }
        });

        DashboardFragment df = new DashboardFragment("Dashboard");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, df).addToBackStack(df.Title).commit();
        toolbarTitle.setText(df.Title);
    }

    public void changeFragment(MyFragment fragment) {
        toolbarTitle.setText(fragment.Title);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, fragment).addToBackStack(fragment.Title).commit();
    }
}