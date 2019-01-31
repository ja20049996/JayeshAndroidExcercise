package com.ja20049996.proficiencyexercise.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private static final String TAG = "RowsAdapter";

    private List<RowItems> rowItemsList;

    public RowsAdapter(List<RowItems> rowItemsList) {
        this.rowItemsList = rowItemsList;
    }


    @Override
    public RowsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RowsAdapter.ViewHolder holder, int position) {

        RowItems rowItems = rowItemsList.get(position);

        if(rowItems !=null){

            holder.fact_title.setText(rowItems.getTitle());
            holder.fact_description.setText(rowItems.getDescription());


            /*Glide.with(holder.fact_title.getContext())
                    .load(rowItems.getImageHref())
                    .into(holder.iv_image);*/

            Log.i(TAG, "onBindViewHolder: URL "+ rowItems.getImageHref());

            Picasso.get()
                    .load(rowItems.getImageHref())
                    .into(holder.iv_image);
        }
    }

    @Override
    public int getItemCount() {
        return rowItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView fact_title;
        private  TextView fact_description;
        private ImageView iv_image;

        public ViewHolder(View itemView) {
            super(itemView);

            fact_title = (TextView) itemView.findViewById(R.id.fact_title);
            fact_description = (TextView) itemView.findViewById(R.id.fact_description);
            iv_image = (ImageView) itemView.findViewById(R.id.fact_image);

        }
    }
}
