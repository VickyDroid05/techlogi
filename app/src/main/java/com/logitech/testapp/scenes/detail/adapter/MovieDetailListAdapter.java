package com.logitech.testapp.scenes.detail.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.logitech.testapp.R;
import com.logitech.testapp.model.KeyValueModel;

import java.util.List;

/**
 * Created by Vigneshwaran G on 13/10/19.
 * //TODO : Should migrate to ViewBinding, update Studio version
 */
public class MovieDetailListAdapter extends RecyclerView.Adapter<MovieDetailListAdapter.MyViewHolder> {

    private List<KeyValueModel> mKeyValueModels;

    public MovieDetailListAdapter(List<KeyValueModel> movieDetail) {
        this.mKeyValueModels = movieDetail;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_description, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        KeyValueModel keyValueModel = mKeyValueModels.get(position);
        holder.setValues(keyValueModel);
    }


    @Override
    public int getItemCount() {
        return mKeyValueModels.size();
    }

    public void updateList(List<KeyValueModel> movieModels) {
        this.mKeyValueModels = movieModels;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_heading);
            description = view.findViewById(R.id.tv_description);
        }

        public void setValues(KeyValueModel keyValueModel) {
            title.setText(keyValueModel.getKey());
            description.setText(keyValueModel.getvalue());
        }
    }

}
