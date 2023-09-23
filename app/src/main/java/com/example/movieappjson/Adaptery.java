package com.example.movieappjson;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private final Context context;
    private final List<MovieModelClass> array;

    public Adaptery(Context context, List<MovieModelClass> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText(array.get(position).getId());
        holder.name.setText(array.get(position).getName());
        holder.release_date.setText(array.get(position).getRelease_date());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameFilm = holder.name.getText().toString();
/*
                Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY, nameFilm);
                context.startActivity(i);
                */


                // Ringtone sozlamalari
                Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                // Agar oldingi ringtone o'chirilmagan bo'lsa, yangi ringtone o'rnating
                Ringtone ringtone = null;
                if (ringtone == null) {
                    ringtone = RingtoneManager.getRingtone(context, ringtoneUri);
                }

                // Ringtone oynatish
                if (ringtone != null && !ringtone.isPlaying()) {
                    ringtone.play();
                }


                Toast.makeText(context, "You chose: " + nameFilm, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("query", nameFilm + " movie");
                context.startActivity(intent);


            }
        });


        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + array.get(position).getImg())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return array.size();
    }


        public static class MyViewHolder extends RecyclerView.ViewHolder {


            TextView id;
            TextView name;
            ImageView img;
            TextView release_date;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                id = itemView.findViewById(R.id.id_txt);
                name = itemView.findViewById(R.id.name_txt);
                img = itemView.findViewById(R.id.imageView);
                release_date = itemView.findViewById(R.id.release_date);

            }
        }
}

