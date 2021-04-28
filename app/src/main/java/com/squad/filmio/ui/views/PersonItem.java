package com.squad.filmio.ui.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squad.filmio.R;

public class PersonItem extends RecyclerView.ViewHolder {
    public ImageView picture;
    public TextView name;

    public PersonItem(@NonNull View itemView) {
        super(itemView);

        picture = itemView.findViewById(R.id.person_image);
        name = itemView.findViewById(R.id.person_name);
    }
}
