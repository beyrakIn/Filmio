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
import com.squad.filmio.api.models.tv.Tv;
import com.squad.filmio.ui.views.SimpleItem;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<SimpleItem> {
    private Context context;
    private List<Tv> tvs;


    public TvAdapter(Context context, List<Tv> tvs) {
        this.context = context;
        this.tvs = tvs;
    }

    @NonNull
    @Override
    public SimpleItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false);
        return new SimpleItem(view);    }

    @Override
    public void onBindViewHolder(@NonNull SimpleItem holder, int position) {
        Tv tv = tvs.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Constants.SRC + tv.getPoster_path())
                .into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return tvs.size();
    }

    public void updateData(List<Tv> tvs){
        this.tvs.addAll(tvs);
        notifyDataSetChanged();
    }
}