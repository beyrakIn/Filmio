package com.squad.filmio.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.methods.GetGenres;
import com.squad.filmio.api.models.genre.Genre;
import com.squad.filmio.api.models.movie.Movie;
import com.squad.filmio.ui.views.VerticalItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        for (int id : movie.getGenre_ids()) {
            new GetGenres().getMoviesGenre(id).enqueue(new Callback<Genre>() {
                @Override
                public void onResponse(Call<Genre> call, Response<Genre> response) {
                    holder.genres.setText(String.format("%s%s/", holder.genres.getText(), response.body().getName()));
                }

                @Override
                public void onFailure(Call<Genre> call, Throwable t) {

                }
            });
        }
        holder.title.setText(movie.getTitle());
        holder.subTitle.setText(movie.getOverview());

        Glide.with(holder.itemView.getContext())
                .load(Constants.POSTER_SRC + movie.getPoster_path())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, String.valueOf(movie.getGenre_ids().size()), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void updateData(List<Movie> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public Genre getGenre(int id) {
        Genre genre = new Genre();
//        new Thread(()->{
        new GetGenres().getMoviesGenre(id).enqueue(new Callback<Genre>() {
            @Override
            public void onResponse(Call<Genre> call, Response<Genre> response) {
                if (response.isSuccessful()) {
                    Genre genre1 = response.body();
                    genre.setId(genre1.getId());
                    genre.setName(genre1.getName());
                }
            }

            @Override
            public void onFailure(Call<Genre> call, Throwable t) {
            }
        });
//        }).start();
        return genre;
    }
}
