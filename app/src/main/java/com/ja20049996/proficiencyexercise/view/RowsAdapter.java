package com.ja20049996.proficiencyexercise.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ja20049996.proficiencyexercise.R;
import com.ja20049996.proficiencyexercise.model.RowItems;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RowsAdapter extends RecyclerView.Adapter<RowsAdapter.ViewHolder> {

    private final List<RowItems> rowItemsList;

    public RowsAdapter(List<RowItems> rowItemsList) {
        this.rowItemsList = rowItemsList;
    }

    @NonNull
    @Override
    public RowsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowsAdapter.ViewHolder holder, int position) {
        RowItems rowItems = rowItemsList.get(position);
        if (rowItems != null) {
            holder.fact_title.setText(rowItems.getTitle());
            holder.fact_description.setText(rowItems.getDescription());
            //Picsso is used to load Images
            Picasso.get()
                    .load(rowItems.getImageHref())
                    .placeholder(R.drawable.loader)
                    .into(holder.iv_image);
        }
    }

    @Override
    public int getItemCount() {
        return rowItemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView fact_title;
        private final TextView fact_description;
        private final ImageView iv_image;

        ViewHolder(View itemView) {
            super(itemView);
            fact_title = itemView.findViewById(R.id.fact_title);
            fact_description = itemView.findViewById(R.id.fact_description);
            iv_image = itemView.findViewById(R.id.fact_image);

        }
    }
}
