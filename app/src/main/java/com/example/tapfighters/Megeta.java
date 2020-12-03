package com.example.tapfighters;

import android.content.Context;

import java.util.ArrayList;

public class Megeta extends Character{

    private ArrayList<Hbox> hitBoxes;

    public Megeta(int x, int y, int speed, int hp, boolean isMove, boolean isAiral) {
        super(x, y, speed, hp, isMove, isAiral);
    }

    public Megeta(){
        super();
    }
    @Override
    public int[] getAttack1(){
       return new int[]{R.drawable.ma1f1, R.drawable.ma1f2, R.drawable.ma1f3, R.drawable.ma1f4, R.drawable.ma1f5, R.drawable.ma1f6, R.drawable.ma1f7, R.drawable.ma1f8, R.drawable.ma1f9};
    }
    @Override
    public int[] getAttack2(){
        return new int[]{R.drawable.ma2f1, R.drawable.ma2f2, R.drawable.ma2f3, R.drawable.ma2f4, R.drawable.ma2f5};
    }
    @Override
    public int[] getAttack3(){
        return new int[]{R.drawable.ma3f1, R.drawable.ma3f2, R.drawable.ma3f3, R.drawable.ma3f4, R.drawable.ma3f5, R.drawable.mb};
    }
    @Override
    public int[] getAttack4(){
        return new int[]{R.drawable.ma4f1, R.drawable.ma4f2, R.drawable.ma4f3, R.drawable.ma4f4, R.drawable.ma4f5, R.drawable.ma4f6};
    }
    @Override
    public int[] getUltimate(){
        return null;
    }

    @Override
    public void run() {
        super.run();

        movement();

    }

    private void movement() {

    }
}
