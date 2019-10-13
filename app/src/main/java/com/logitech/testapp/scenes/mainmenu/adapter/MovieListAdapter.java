package com.logitech.testapp.scenes.mainmenu.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.logitech.testapp.R;
import com.logitech.testapp.model.MovieModel;

import java.util.List;

/**
 * Created by Vigneshwaran G on 13/10/19.
 * //TODO : Should migrate to ViewBinding, update Studio version
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private List<MovieModel> moviesList;
    private MovieListClickListener mListener;

    public MovieListAdapter(List<MovieModel> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieModel movie = moviesList.get(position);
        holder.setValues(movie);
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void updateList(List<MovieModel> movieModels) {
        this.moviesList = movieModels;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView ivPoster;

        public MyViewHolder(View view) {
            super(view);
            ivPoster = view.findViewById(R.id.iv_movie_poster);
            title = view.findViewById(R.id.tv_movie_title);
            genre = view.findViewById(R.id.tv_movie_description);
            year = view.findViewById(R.id.tv_movie_description2);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onItemClicked(getAdapterPosition());
                    }
                }
            });
        }

        public void setValues(MovieModel movieModel) {
            Glide.with(ivPoster)
                    .load(movieModel.getPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.placeholder_small)
                            .error(R.drawable.placeholder_small))
                    .into(ivPoster);
            if (!TextUtils.isEmpty(movieModel.getTitle())) {
                title.setText(movieModel.getTitle());
            }
            if (!TextUtils.isEmpty(movieModel.getLanguage())) {
                genre.setText(movieModel.getLanguage());
            }
            if (!TextUtils.isEmpty(movieModel.getGenre())) {
                year.setText(movieModel.getGenre());
            }

        }
    }

    public void setMovieListClickListener(MovieListClickListener listener) {
        this.mListener = listener;
    }

    public interface MovieListClickListener {
        void onItemClicked(int id);
    }

}
