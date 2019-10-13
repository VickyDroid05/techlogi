package com.logitech.testapp.scenes.mainmenu.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.logitech.testapp.R;
import com.logitech.testapp.databinding.ItemMovieBinding;
import com.logitech.testapp.model.MovieModel;

import java.util.List;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private List<MovieModel> moviesList;
    private MovieListClickListener mListener;
    private ItemMovieBinding mViewBinding;

    public MovieListAdapter(List<MovieModel> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_movie, parent, false);

        return new MovieViewHolder(mViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel movie = moviesList.get(position);
        holder.setValues(movie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    /**
     * Method to update the latest list to recycler view
     *
     * @param movieModels The movie models
     */
    public void updateList(List<MovieModel> movieModels) {
        this.moviesList = movieModels;
        notifyDataSetChanged();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieViewHolder(ItemMovieBinding viewBinding) {
            super(viewBinding.getRoot());
            mViewBinding = viewBinding;

            mViewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onItemClicked(getAdapterPosition());
                    }
                }
            });
        }

        /**
         * Method to the set the value to view
         *
         * @param movieModel The Movie Model
         */
        public void setValues(MovieModel movieModel) {
            Glide.with(mViewBinding.ivMoviePoster)
                    .load(movieModel.getPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.placeholder_small)
                            .error(R.drawable.placeholder_small))
                    .into(mViewBinding.ivMoviePoster);
            if (!TextUtils.isEmpty(movieModel.getTitle())) {
                mViewBinding.tvMovieTitle.setText(movieModel.getTitle());
            }
            if (!TextUtils.isEmpty(movieModel.getLanguage())) {
                mViewBinding.tvLanguage.setText(movieModel.getLanguage());
            }
            if (!TextUtils.isEmpty(movieModel.getGenre())) {
                mViewBinding.tvGenre.setText(movieModel.getGenre());
            }
        }
    }

    /**
     * Method to set the movie click listener
     *
     * @param listener The Listener
     */
    public void setMovieListClickListener(MovieListClickListener listener) {
        this.mListener = listener;
    }

    /**
     * Listener for click item of movie list
     */
    public interface MovieListClickListener {
        void onItemClicked(int id);
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
