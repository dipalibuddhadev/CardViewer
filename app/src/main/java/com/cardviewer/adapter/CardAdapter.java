package com.cardviewer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cardviewer.R;
import com.cardviewer.model.CardListResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.RecyclerViewHolder> {
    private final List<CardListResponse> cardListModels;
    private final Context mContext;

    public CardAdapter(List<CardListResponse> cardListModels, Context mContext) {
        this.cardListModels = cardListModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_card, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview.
        CardListResponse model = cardListModels.get(position);
        holder.mTvCardNumber.setText(model.getCardNumber());
        holder.mTvExpiryDate.setText(parseDate(model.getExpiryDate()));
        holder.mTvCardType.setText(model.getCardType());

    }
    // This method format date
    public String parseDate(String time) {
        String inputPattern = "yyyy-mm-dd";
        String outputPattern = "dd MMM yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return cardListModels.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvCardNumber;
        private final TextView mTvExpiryDate;
        private final TextView mTvCardType;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvCardNumber = itemView.findViewById(R.id.tvCardNumber);
            mTvExpiryDate = itemView.findViewById(R.id.tvExpiryDate);
            mTvCardType = itemView.findViewById(R.id.tvCardType);
        }
    }
}

