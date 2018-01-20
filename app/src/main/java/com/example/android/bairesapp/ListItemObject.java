package com.example.android.bairesapp;

/**
 * Created by Rafael on 2/1/2018.
 */

public class ListItemObject {
    // Text on top of image
    private int mName;
    // Tipe of place text
    private int mTypeOfPlace;
    // Place description
    private int mPlaceDescription;
    // Image ID
    private int mImageResourceId;
    // Phrase in Spanish
    private int mSpanishText;
    // Phrase in English
    private int mEnglishText;
    // Audio of phrase
    private int mAudioResourceId;
    // Coordinates of one place
    private String mCoordinates;
    // Icon describing phrase
    private int mIconImage;

    /**
     * Constructor for attractions and night categories
     * @param name describing an attraction or night place
     * @param imageId Resource of an image
     */
    public ListItemObject(int name, int imageId, int typeOfPlace, int placeDescription, String coordinates) {
        mName = name;
        mImageResourceId = imageId;
        mTypeOfPlace = typeOfPlace;
        mPlaceDescription = placeDescription;
        mCoordinates = coordinates;
    }

    /**
     * Constructor for phrases category
     * @param spanishText Spanish translation of phrase
     * @param englishText English translation of phrase
     * @param iconImage Resource ID of icon describing phrase
     * @param audioResourceId Resource ID of audio
     */
    public ListItemObject(int spanishText, int englishText, int iconImage, int audioResourceId) {
        mSpanishText = spanishText;
        mEnglishText = englishText;
        mIconImage = iconImage;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get image resource ID
     *
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getIconImage() {
        return mIconImage;
    }

    public int getSpanishText() {
        return mSpanishText;
    }

    public int getEnglishText() {
        return mEnglishText;
    }

    /**
     * Get headerText
     */
    public int getName() {
        return mName;
    }


    /**
     * Get type of place
     */
    public int getTypeOfPlace() {
        return mTypeOfPlace;
    }


    /**
     * Get place description
     */
    public int getPlaceDescription() {
        return mPlaceDescription;
    }

    /**
     * Get coordinates
     */
    public String getCoordinates() {
        return mCoordinates;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}

