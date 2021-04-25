package com.squad.filmio.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.views.VerticalItem;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<VerticalItem> {
    private Context context;
    private List<Movie> movies;

    public UpcomingAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VerticalItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item, parent, false);
        return new VerticalItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalItem holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.subTitle.setText(movie.getOverview());

        Glide.with(holder.itemView.getContext())
                .load(Constants.SRC + movie.getPoster_path())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
