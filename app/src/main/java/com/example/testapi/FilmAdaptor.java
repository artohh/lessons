package com.example.testapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdaptor extends RecyclerView.Adapter<FilmAdaptor.ViewHolder>{

    private LayoutInflater inflater;
    private List<Film> listFilm;

    public FilmAdaptor(Context context, List<Film> list){
        this.listFilm = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Film film = listFilm.get(position);
        holder.filmName.setText(film.getFilmName());
        holder.filmDesc.setText(film.getFilmDesc());
        Picasso.get().load(film.getFilmCoverURL()).into(holder.filmCover);

    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView filmName;
        TextView filmDesc;
        ImageView filmCover;
        ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.Clayout);
            filmCover = itemView.findViewById(R.id.imCover);
            filmDesc = itemView.findViewById(R.id.tvFilmDesc);
            filmName = itemView.findViewById(R.id.tvFilm);
        }
    }
}
