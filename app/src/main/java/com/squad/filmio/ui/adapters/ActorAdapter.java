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
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.ui.views.PersonItem;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<PersonItem> {
    private Context context;
    private List<Person> people;
    private int action;

    public ActorAdapter(Context context, List<Person> people, int action) {
        this.context = context;
        this.people = people;
        this.action = action;
    }

    @NonNull
    @Override
    public PersonItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonItem holder, int position) {
        Person person = people.get(position);
        holder.name.setText(person.getName());
        Glide.with(holder.itemView.getContext())
                .load(Constants.POSTER_SRC + person.getProfile_path())
                .error(R.drawable.ic_user)
                .into(holder.picture);

        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("actorId", person.getId());
            Navigation.findNavController(v).navigate(action, args);
        });
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void updateData(List<Person> people) {
//        this.people.addAll(people);
        this.people = people;
        notifyDataSetChanged();
    }
}
