package com.example.tapfighters;

public class Hbox {
    private int startX, startY, stopX, stopY;
    private boolean HitMoode;

    public Hbox(int startX, int startY, int stopX, int stopY, boolean hitMoode) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
        HitMoode = hitMoode;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getStopX() {
        return stopX;
    }

    public void setStopX(int stopX) {
        this.stopX = stopX;
    }

    public int getStopY() {
        return stopY;
    }

    public void setStopY(int stopY) {
        this.stopY = stopY;
    }

    public boolean isHitMoode() {
        return HitMoode;
    }

    public void setHitMoode(boolean hitMoode) {
        HitMoode = hitMoode;
    }

    public boolean isHit() {
        return HitMoode;
    }
}
