package com.realimage.model;

import android.graphics.drawable.Drawable;

public class PexelsModel {

    private int id;
    private String photographer;
    private String avgColor;
    private String photographer_id;
    private String original;
    private String large2x;
    private String large;
    private String medium;
    private String small;
    private String portrait;
    private String landscape;
    private String tiny;
    private String alt;

    public PexelsModel(){

    }
    public PexelsModel(String photographer,String large2x,String avgColor){
       this.large2x = large2x;
       this.photographer = photographer;
       this.avgColor = avgColor;
    }
    public PexelsModel(int id, String photographer, String avgColor, String photographer_id, String original, String large2x,
                       String large, String medium, String small, String portrait, String landscape,
                       String tiny, String alt) {
        this.id = id;
        this.photographer = photographer;
        this.avgColor = avgColor;
        this.photographer_id = photographer_id;
        this.original = original;
        this.large2x = large2x;
        this.large = large;
        this.medium = medium;
        this.small = small;
        this.portrait = portrait;
        this.landscape = landscape;
        this.tiny = tiny;
        this.alt = alt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotographer() {
        return photographer;
    }

    public String getAvgColor() {
        return avgColor;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }
    public void setAvgColor(String avgColor) {
        this.avgColor = avgColor;
    }

    public String getPhotographer_id() {
        return photographer_id;
    }

    public void setPhotographer_id(String photographer_id) {
        this.photographer_id = photographer_id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getLarge2x() {
        return large2x;
    }

    public void setLarge2x(String large2x) {
        this.large2x = large2x;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public String getTiny() {
        return tiny;
    }

    public void setTiny(String tiny) {
        this.tiny = tiny;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
