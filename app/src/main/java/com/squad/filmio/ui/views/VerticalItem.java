package com.squad.filmio.ui.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;

public class VerticalItem extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView title, subTitle;

    public VerticalItem(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_vertical_picture);
        title = itemView.findViewById(R.id.item_title);
        subTitle = itemView.findViewById(R.id.item_subtitle);
    }
}
