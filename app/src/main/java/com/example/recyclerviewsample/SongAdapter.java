package com.example.recyclerviewsample;

import static androidx.recyclerview.widget.RecyclerView.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    Context mCtx;
    ArrayList<Song> songs;
    LayoutInflater mInflater;

    public SongAdapter(Context mCtx, ArrayList<Song> songs) {
        this.mCtx = mCtx;
        this.songs = songs;
        mInflater = LayoutInflater.from(mCtx);
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.row_song,parent,false);
        return new SongViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder holder, int position) {
        String currentSongTitle = songs.get(position).title;
        holder.tvSongTitle.setText(currentSongTitle);
        String currentSongArtist = songs.get(position).artist;
        holder.tvSongArtist.setText(currentSongArtist);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        TextView tvSongTitle, tvSongArtist;
        SongAdapter adapter;
        public SongViewHolder(@NonNull View itemView, SongAdapter adapter) {
            super(itemView);
            tvSongTitle = itemView.findViewById(R.id.tvSongTitle);
            tvSongArtist = itemView.findViewById(R.id.tvSongArtist);
            this.adapter=adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mCtx, tvSongTitle.getText().toString()+" is clicked.", Toast.LENGTH_SHORT).show();
        }
    }
}
