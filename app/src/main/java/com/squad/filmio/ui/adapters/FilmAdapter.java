package com.squad.filmio.ui.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.models.movie.Film;
import com.squad.filmio.ui.views.SimpleItem;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<SimpleItem> {
    private Context context;
    private List<Film> films;
    private int action;
    private boolean isMovie;

    public FilmAdapter(Context context, List<Film> films, int action, boolean isMovie) {
        this.context = context;
        this.films = films;
        this.action = action;
        this.isMovie = isMovie;
    }

    @NonNull
    @Override
    public SimpleItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false);
        return new SimpleItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleItem holder, int position) {
        Film film = films.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Constants.POSTER_SRC + film.getPoster_path())
                .into(holder.picture);

        Bundle args = new Bundle();
        args.putInt(isMovie ? "movieId" : "tvId", film.getId());
//        args.putInt("tvId", film.getId());


        holder.itemView.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(action, args);
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void updateData(List<Film> films) {
//        this.movies.addAll(movies);
        this.films = films;
        notifyDataSetChanged();
    }
}
