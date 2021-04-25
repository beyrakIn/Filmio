package com.squad.filmio.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.squad.filmio.Constants;
import com.squad.filmio.R;
import com.squad.filmio.api.models.movie.Movie;

import java.util.List;

public class CoverAdapter extends PagerAdapter {
    private List<Movie> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public CoverAdapter(List<Movie> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        Movie movie = models.get(position);
        View view = layoutInflater.inflate(R.layout.cover_item, container, false);
        ImageView coverPictures;

        coverPictures = view.findViewById(R.id.item_cover_picture);
        Glide.with(context)
                .load(Constants.SRC + movie.getBackdrop_path())
                .into(coverPictures);

        coverPictures.setOnClickListener(v -> {
            Toast.makeText(context, movie.getTitle(), Toast.LENGTH_SHORT).show();
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
