package com.example.tapfighters;


import android.util.Log;

public class Character extends Thread{

    private int x, y, speed, hp;
    private boolean shouldMove, ShouldAirale;

    public Character(int x, int y, int speed, int hp, boolean shouldMove, boolean ShouldAirale) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.hp = hp;
        this.ShouldAirale = ShouldAirale;
        this.shouldMove = shouldMove;
    }

    public Character() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public boolean ShouldMove() {
        return shouldMove;
    }

    public void setMoveState(boolean shouldMove) {
        this.shouldMove = shouldMove;
    }

    public boolean isShouldAirale() {
        return ShouldAirale;
    }

    public void setShouldAirale(boolean shouldAirale) {
        ShouldAirale = shouldAirale;
    }

    public void takeDamage(int damage) {
        this.hp = this.hp-damage;
    }

    public void step(final int steps){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < steps; i ++){
                    x += speed;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).run();
    }

    public int[] getAttack1(){
        return null;
    }
    public int[] getAttack2(){
        return null;
    }
    public int[] getAttack3(){
        return null;
    }
    public int[] getAttack4(){
        return null;
    }
    public int[] getUltimate(){
        return null;
    }
    private int[] getHurtFrams(){
        return null;
    }

}
