package com.logitech.testapp.scenes.detail.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.logitech.testapp.R;
import com.logitech.testapp.databinding.ItemMovieDescriptionBinding;
import com.logitech.testapp.model.KeyValueModel;

import java.util.List;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class MovieDetailListAdapter extends RecyclerView.Adapter<MovieDetailListAdapter.DetailViewHolder> {

    private List<KeyValueModel> mKeyValueModels;

    public MovieDetailListAdapter(List<KeyValueModel> movieDetail) {
        this.mKeyValueModels = movieDetail;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieDescriptionBinding viewDataBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_movie_description, parent, false);

        return new DetailViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        KeyValueModel keyValueModel = mKeyValueModels.get(position);
        holder.setValues(keyValueModel);
    }

    @Override
    public int getItemCount() {
        return mKeyValueModels.size();
    }

    /**
     * Method to update the List with new movie models
     *
     * @param movieModels The Movie model
     */
    public void updateList(List<KeyValueModel> movieModels) {
        this.mKeyValueModels = movieModels;
        notifyDataSetChanged();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

        private ItemMovieDescriptionBinding mViewBinding;

        private DetailViewHolder(ItemMovieDescriptionBinding viewBinding) {
            super(viewBinding.getRoot());
            this.mViewBinding = viewBinding;
        }

        /**
         * Method to set the heading and title to view
         *
         * @param keyValueModel The Key Value model
         */
        public void setValues(KeyValueModel keyValueModel) {
            mViewBinding.tvHeading.setText(keyValueModel.getKey());
            mViewBinding.tvDescription.setText(keyValueModel.getvalue());
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
