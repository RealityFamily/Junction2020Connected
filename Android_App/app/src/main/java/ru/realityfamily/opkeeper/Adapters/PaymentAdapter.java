package ru.realityfamily.opkeeper.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ru.realityfamily.opkeeper.Fragments.InfoPatternFragment;
import ru.realityfamily.opkeeper.Fragments.MyFragment;
import ru.realityfamily.opkeeper.MainActivity;
import ru.realityfamily.opkeeper.Models.Pattern;
import ru.realityfamily.opkeeper.Models.Transaction;
import ru.realityfamily.opkeeper.R;

import static java.time.temporal.ChronoUnit.DAYS;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {
    List<Transaction> elementsTransactions = null;
    List<Pattern> elementsPatterns = null;

    MainActivity activity;
    MyFragment oldFragment;

    public PaymentAdapter(List<Transaction> elementsTransactions, List<Pattern> elementsPatterns,
                          MainActivity activity) {
        this.elementsTransactions = elementsTransactions;
        this.elementsPatterns = elementsPatterns;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_card_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        if (elementsTransactions != null && elementsPatterns == null) {
            holder.namePaymentElement.setText(elementsTransactions.get(position).getCounterCompanyName());
            holder.datePaymentElement.setText(elementsTransactions.get(position).getTimeStamp().toString());
            holder.amountPaymentElement.setText(elementsTransactions.get(position).getAmount().toString());
        } else if (elementsPatterns != null && elementsTransactions == null){
            holder.namePaymentElement.setText(elementsPatterns.get(position).getPatternName());

            String patternLongString = "";
            long patternLong = DAYS.between(
                    OffsetDateTime.parse(elementsPatterns.get(position).getDetectedStart(), DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    OffsetDateTime.parse(elementsPatterns.get(position).getDetectedEnd(), DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            if (patternLong > 365) {
                patternLongString = patternLong / 365 + " years";
            } else if (patternLong > 30) {
                patternLongString = patternLong / 30 + " months";
            } else if (patternLong > 7) {
                patternLongString = patternLong / 7 + " weeks";
            } else {
                patternLongString = patternLong + " days";
            }
            holder.datePaymentElement.setText("for " + patternLongString);
            holder.amountPaymentElement.setText(elementsPatterns.get(position).getAllAmount().toString());

            holder.paymentElement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.changeFragment(
                            new InfoPatternFragment(
                                    elementsPatterns.get(position).getId().toString(),
                                    "Pattern"));
                }
            });
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

        CardView paymentElement;
        TextView namePaymentElement;
        TextView datePaymentElement;
        TextView amountPaymentElement;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);

            paymentElement = itemView.findViewById(R.id.paymentElement);
            namePaymentElement = itemView.findViewById(R.id.namePaymentElement);
            datePaymentElement = itemView.findViewById(R.id.datePaymentElement);
            amountPaymentElement = itemView.findViewById(R.id.amountPaymentElement);
        }
    }
}
