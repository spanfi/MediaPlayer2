package com.example.android.mediaplayer2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class JazzActivity extends AppCompatActivity {

    String[] artistsName;
    String[] albumsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);

        artistsName = getResources().getStringArray(R.array.jazzArtists);
        albumsName = getResources().getStringArray(R.array.jazzAlbums);
        int artistsSize = artistsName.length;

        int[] coverAlbumsId = {
                R.mipmap.img_08_ts,
                R.mipmap.img_09_md,
                R.mipmap.img_10_la,
        };

        // Create an arrayList of albums
        final ArrayList<Albums> albums = new ArrayList<>();
        for (int i = 0; i < artistsSize; i++) {
            albums.add(new Albums(artistsName[i], albumsName[i], coverAlbumsId[i]));
        }

        // Create an {@link AlbumsAdapter}, whose data source is a list of {@link Albums}s. The
        // adapter knows how to create list items for each item in the list.
        AlbumsAdapter adapter = new AlbumsAdapter(JazzActivity.this, albums, R.color.app_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listViewId = (ListView) findViewById(R.id.listViewAlbum);

        // Make the {@link ListView} use the {@link AlbumsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Album} in the list.
        listViewId.setAdapter(adapter);

    }
}
