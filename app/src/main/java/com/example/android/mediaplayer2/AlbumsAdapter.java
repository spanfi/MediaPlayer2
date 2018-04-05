package com.example.android.mediaplayer2;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumsAdapter extends ArrayAdapter<Albums> {
    // Resource ID for the background color for this list of albums
    private int mColorResourceId;

    /**
     * Create a new {@link AlbumsAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param androidAlbums    is the list of {@link Albums}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */

    public AlbumsAdapter(Activity context, ArrayList<Albums> androidAlbums, int colorResourceId) {
        super(context, 0, androidAlbums);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Albums currentAndroidAlbums = getItem(position);

        // Find the TextView in the .xml layout with the ID artistTextView
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artistTextView);
        // Get the artist from the current Albums object and
        // set this text on the name TextView
        artistTextView.setText(currentAndroidAlbums.getArtistName());

        // Find the TextView in the list_item.xml layout with the ID albumTextView
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.albumTextView);
        // Get the album from the current Albums object and
        // set this text on the name TextView
        albumTextView.setText(currentAndroidAlbums.getAlbumName());

        // Find the ImageView in the list_item.xml layout with the ID imageCover
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageViewCover);

        // Check if an image is provided for this word or not
        if (currentAndroidAlbums.hasImage()) {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to imageView
            //If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentAndroidAlbums.getAlbumImageId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
