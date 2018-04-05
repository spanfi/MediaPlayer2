package com.example.android.mediaplayer2;

public class Albums {

    //Artist name
    private String artistN;

    //Album name
    private String albumN;

    //Image resource ID for the albums, no image provided as default at start app
    private int albumImgId = NO_IMAGE_PROVIDED;

    //Returns whether or not there is an image for this album.
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Albums object.
     *
     * @param artistName   name of the band or artist
     * @param albumName    the title of the disc
     * @param albumImageId the CD cover ID
     */
    public Albums(String artistName, String albumName, int albumImageId) {
        artistN = artistName;
        albumN = albumName;
        albumImgId = albumImageId;
    }

    //Get the artist name
    public String getArtistName() {
        return artistN;
    }

    //Get the album name
    public String getAlbumName() {
        return albumN;
    }

    //Return the image resource ID of the image (CD cover).

    public int getAlbumImageId() {
        return albumImgId;
    }

    //Returns whether or not there is an image for this word.
    public boolean hasImage() {
        return albumImgId != NO_IMAGE_PROVIDED;
    }
}
