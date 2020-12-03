package com.example.tapfighters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private boolean isPlaying;
    private Paint paint;
    public Character p1, p2;
    private int screenX, screenY;


    @SuppressLint("ClickableViewAccessibility")
    public GameView(Context context, int screenX, int screenY, int p1, int p2) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;

        paint = new Paint();

        //player 1
        if(p1 == 0) {
            p1 = new Random().nextInt((5 - 1) + 1) + 1;
        }
        if(p1 == 1) {
            this.p1 = new Megeta(0,0,20,0,false,false);
        }
        else if(p1 == 2) {
            this.p1 = new Character();
        }
        else if(p1 == 3) {
            this.p1 = new Character();
        }
        else if(p1 == 4) {
            this.p1 = new Character();
        }
        //player 2
        if(p2 == 0) {
            p2 = new Random().nextInt((5 - 1) + 1) + 1;
        }
        if(p2 == 1) {
            this.p2 = new Megeta();
        }
        else if(p2 == 2) {
            this.p2 = new Character();
        }
        else if(p2 == 3) {
            this.p2 = new Character();
        }
        else if(p2 == 4) {
            this.p2 = new Character();
        }

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                doThis(getWhatButton(motionEvent.getX(), motionEvent.getY()));
                return false;
            }
        });
    }

    private void doThis(Integer whatButton) {
        if(whatButton == 0){
            this.p1.step(-5);
        }
        else if(whatButton == 1){
            this.p1.step(5);
        }
        else if(whatButton == 2){

        }
        else if(whatButton == 3){

        }
        else if(whatButton == 4){

        }
        else if(whatButton == 5){

        }
    }

    private Integer getWhatButton(float x, float y) {
        if(40 <= x && x <= 297 && 882 <= y && y <= 1040){//left
            return 0;
        }
        else if(346 <= x && x <= 603 && 882 <= y && y <= 1040){//right
            return 1;
        }
        else if(1201 <= x && x <= 1453 && 788 <= y && y <= 912){//attack 1
            return 2;
        }
        else if(1495 <= x && x <= 1747 && 788 <= y && y <= 912){//attack 2
            return 3;
        }
        else if(1201 <= x && x <= 1453 && 934 <= y && y <= 1058){//attack 3
            return 4;
        }
        else if(1495 <= x && x <= 1747 && 934 <= y && y <= 1058){//attack 4
            return 5;
        }
        else if(628 <= x && x <= 1178 && 1015 <= y && y <= 1056){//ult
            return 5;
        }
        return null;
    }


    @Override
    public void run() {

        while(isPlaying){
            draw();
            update();
        }

    }

    private void update() {

    }

    private void draw() {

        if(getHolder().getSurface().isValid()){
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.backgroundstage1), screenX, screenY, false), 0, 0, paint);
            canvas.drawBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hud), screenX, screenY, false), 0, 0, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }

    }


    public void resume() {

        isPlaying = true;
        thread = new Thread(this);
        thread.start();

    }

    public void pause() {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
