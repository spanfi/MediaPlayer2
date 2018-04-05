package com.example.android.mediaplayer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RockSongActivity extends AppCompatActivity {

    private String[] songName;
    private ArrayAdapter<String> songAdapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_song_list);

        songName = getResources().getStringArray(R.array.rockSong);
        int i = songName.length;
        Toast.makeText(this, Integer.toString(i), Toast.LENGTH_LONG).show();

       songAdapter = new ArrayAdapter<>(this, R.layout.album_song_list, songName);
        lv = findViewById(R.id.listViewAlbumSong);
        lv.setAdapter(songAdapter);




    }
}
