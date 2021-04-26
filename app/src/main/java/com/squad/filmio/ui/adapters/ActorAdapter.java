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
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.ui.views.PersonView;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<PersonView> {
    private Context context;
    private List<Person> people;

    public ActorAdapter(Context context, List<Person> people) {
        this.context = context;
        this.people = people;
    }

    @NonNull
    @Override
    public PersonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person, parent, false);
        return new PersonView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonView holder, int position) {
        Person person = people.get(position);
        holder.name.setText(person.getName());
        Glide.with(holder.itemView.getContext())
                .load(Constants.POSTER_SRC + person.getProfile_path())
                .into(holder.picture);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, String.valueOf(person.getPopularity()), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void updateData(List<Person> people) {
        this.people.addAll(people);
        notifyDataSetChanged();
    }
}
