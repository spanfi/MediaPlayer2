package com.example.android.mediaplayer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RockActivity extends AppCompatActivity {

    private String[] artistsName;
    private String[] albumsName;
    private int artistsSize;
    private int positionA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);

        artistsName = getResources().getStringArray(R.array.rockArtists);
        albumsName = getResources().getStringArray(R.array.rockAlbums);
        artistsSize = artistsName.length;

        int[] coverAlbumsId = {
                R.mipmap.img_00_pf,
                R.mipmap.img_01_rem,
                R.mipmap.img_02_pg,
                R.mipmap.img_03_hey,
                R.mipmap.img_04_q,
        };

        // Create an arrayList of albums
        final ArrayList<Albums> albums = new ArrayList<>();
        for (int i = 0; i < artistsSize; i++) {
            albums.add(new Albums(artistsName[i], albumsName[i], coverAlbumsId[i]));
        }

        // Create an {@link AlbumsAdapter}, whose data source is a list of {@link Albums}s. The
        // adapter knows how to create list items for each item in the list.
        AlbumsAdapter adapter = new AlbumsAdapter(RockActivity.this, albums, R.color.app_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listViewId = findViewById(R.id.listViewAlbum);

        // Make the {@link ListView} use the {@link AlbumsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Albums} in the list.
        listViewId.setAdapter(adapter);

        listViewId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Albums} object at the given position the user clicked on
                Albums albumsPosition = albums.get(position);

                Intent rockIntent = new Intent(RockActivity.this, RockSongActivity.class);
                startActivity(rockIntent);
            }
        });


    }
}
