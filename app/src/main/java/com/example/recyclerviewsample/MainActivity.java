package com.example.recyclerviewsample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;

    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the recyclerview from layout
        rvMain = findViewById(R.id.rvMain);

        //prepare data here
        songs = new ArrayList<Song>();
        for(int i=0;i<20;i++){
            songs.add(new Song("Song Title "+i,"Artist 1"));
        }

        //plug the adapter to the existing recyclerview
        SongAdapter songAdapter = new SongAdapter(this,songs);
        rvMain.setAdapter(songAdapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

    }
}