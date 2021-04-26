package com.squad.filmio.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.ui.views.SimpleItem;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<SimpleItem> {
    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public SimpleItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false);
        return new SimpleItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleItem holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Constants.POSTER_SRC + movie.getPoster_path())
                .into(holder.picture);

        holder.itemView.setOnClickListener(v -> {
//            Navigation.findNavController(v).navigate(R.id.action_navigation_movies_to_movieDetailsFragment);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void updateData(List<Movie> movies){
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }
}
