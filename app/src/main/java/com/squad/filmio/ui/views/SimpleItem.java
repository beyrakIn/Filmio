package com.squad.filmio.ui.views;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;

public class SimpleItem extends RecyclerView.ViewHolder {
    public ImageView picture;

    public SimpleItem(@NonNull View itemView) {
        super(itemView);
        picture = itemView.findViewById(R.id.item_simple_picture);
    }
}
