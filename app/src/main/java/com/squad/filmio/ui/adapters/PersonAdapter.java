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
import com.squad.filmio.api.models.person.Person;
import com.squad.filmio.ui.views.PersonView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonView> {
    private Context context;
    private List<Person> people;

    public PersonAdapter(Context context, List<Person> people) {
        this.context = context;
        this.people = people;
    }

    @NonNull
    @Override
    public PersonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false);
        return new PersonView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonView holder, int position) {
        Person person = people.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Constants.POSTER_SRC + person.getProfile_path())
                .into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void update(List<Person> people){
        this.people.addAll(people);
        notifyDataSetChanged();
    }
}
