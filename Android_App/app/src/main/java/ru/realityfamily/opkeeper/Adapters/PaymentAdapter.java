package ru.realityfamily.opkeeper.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.realityfamily.opkeeper.Models.Pattern;
import ru.realityfamily.opkeeper.Models.Transaction;
import ru.realityfamily.opkeeper.R;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {
    List<Transaction> elementsTransactions = null;
    List<Pattern> elementsPatterns = null;

    public PaymentAdapter(List<Transaction> elementsTransactions, List<Pattern> elementsPatterns) {
        this.elementsTransactions = elementsTransactions;
        this.elementsPatterns = elementsPatterns;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_cardview_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        if (elementsTransactions != null) {
            holder.namePaymentElement.setText(elementsTransactions.get(position).getCounterCompanyName());
            holder.datePaymentElement.setText(elementsTransactions.get(position).getTimeStamp().toString());
            holder.amountPaymentElement.setText(elementsTransactions.get(position).getAmount().toString());
        } else if (elementsPatterns != null){
            holder.namePaymentElement.setText(elementsPatterns.get(position).getPatternName());
            holder.datePaymentElement.setText("from " + elementsPatterns.get(position).getDetectedStart().toString());
            holder.amountPaymentElement.setText(elementsPatterns.get(position).getAllAmount().toString());
        }
    }

    @Override
    public int getItemCount() {
        if (elementsPatterns != null) {
            return elementsPatterns.size();
        } else if (elementsTransactions != null) {
            return elementsTransactions.size();
        } else {
            return 0;
        }
    }

    class PaymentViewHolder extends RecyclerView.ViewHolder{

        TextView namePaymentElement;
        TextView datePaymentElement;
        TextView amountPaymentElement;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);

            namePaymentElement = itemView.findViewById(R.id.namePaymentElement);
            datePaymentElement = itemView.findViewById(R.id.datePaymentElement);
            amountPaymentElement = itemView.findViewById(R.id.amountPaymentElement);
        }
    }
}
