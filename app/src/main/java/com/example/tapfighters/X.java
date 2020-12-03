package com.example.tapfighters;

import java.util.ArrayList;

public class X extends Character{
    private ArrayList<Hbox> hitBoxes;

    public X(int x, int y, int speed, int hp, boolean isMove, boolean isAiral) {
        super(x, y, speed, hp, isMove, isAiral);
    }

    public X(){
        super();
    }
    @Override
    public int[] getAttack1(){
        return new int[]{};
    }
    @Override
    public int[] getAttack2(){
        return new int[]{};
    }
    @Override
    public int[] getAttack3(){
        return new int[]{};
    }
    @Override
    public int[] getAttack4(){
        return new int[]{};
    }
    @Override
    public int[] getUltimate(){
        return new int[]{};
    }

    @Override
    public void run() {
        super.run();
    }
}
