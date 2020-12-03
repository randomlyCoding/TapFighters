package com.example.tapfighters;

import android.widget.ImageView;

import androidx.annotation.NonNull;

public class UpdateVS extends Thread{

    private int c, delayM, delayN;
    private ImageView vs;
    private boolean isRunning = true;

    public UpdateVS(int c, int delayM, int delayN, @NonNull ImageView vs) {
        this.c = c;
        this.delayM = delayM;
        this.delayN = delayN;
        this.vs = vs;
    }

    @Override
    public void run() {
        super.run();
        while(isRunning){

            if(c == 0) {
                c++;
                vs.setBackgroundResource(R.drawable.vs1);
                sleep();
            }
            else if(c == 1) {
                c++;
                vs.setBackgroundResource(R.drawable.vs2);
                sleep();
            }
            else if(c == 2) {
                c++;
                vs.setBackgroundResource(R.drawable.vs3);
                sleep();
            }
            else
                c = 0;
        }
    }

    public void stopThread(){

    }

    private void sleep(){
        try {
            Thread.sleep(delayM, delayN);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setDelayN(int delayN) {
        this.delayN = delayN;
    }

    public void setDelayM(int delayM) {
        this.delayM = delayM;
    }
    public void setDelay(int delayM, int delayN){
        this.delayN = delayN;
        this.delayM = delayM;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setVs(ImageView vs) {
        this.vs = vs;
    }

    public int getC() {
        return c;
    }

    public int getDelayN() {
        return delayN;
    }

    public ImageView getVs() {
        return vs;
    }

    public boolean getIsRunning(){
        return isRunning;
    }

}
