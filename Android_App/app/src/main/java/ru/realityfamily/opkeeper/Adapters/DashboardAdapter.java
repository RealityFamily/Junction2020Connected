package ru.realityfamily.opkeeper.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.UUID;

import ru.realityfamily.opkeeper.Fragments.ChallengeFragment;
import ru.realityfamily.opkeeper.Fragments.DashboardFragment;
import ru.realityfamily.opkeeper.Fragments.GoalFragment;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.R;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {
    enum TypeElementInfo{
        Goal,
        Challenge
    }

    List<SmallInfo> elements;
    TypeElementInfo typeElement;
    MainActivity activity;

    public DashboardAdapter(List<SmallInfo> elements, TypeElementInfo typeElement, MainActivity activity) {
        this.elements = elements;
        this.typeElement = typeElement;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashboardViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_cardview_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        holder.elementTitle.setText(elements.get(position).name);

        switch (typeElement) {

            case Goal:
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.changeFragment(new GoalFragment(, "Goal")
                                , new DashboardFragment("Dashboard"));
                    }
                });
                break;
            case Challenge:
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.changeFragment(new ChallengeFragment(, "Challenge")
                                , new DashboardFragment("Dashboard"));
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    class DashboardViewHolder extends RecyclerView.ViewHolder{

        TextView elementTitle;
        CardView cardView;

        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);

            elementTitle = itemView.findViewById(R.id.elementTitle);
            cardView = itemView.findViewById(R.id.dashboardCard);
        }
    }

    class SmallInfo {
        String name;
        UUID id;

        public SmallInfo(String name, UUID id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }
    }
}
