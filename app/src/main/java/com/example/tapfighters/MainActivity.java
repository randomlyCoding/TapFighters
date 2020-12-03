package com.example.tapfighters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView op1, op2;
    private Animation animation1, animation2;
    private int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        animation1 = AnimationUtils.loadAnimation(this, R.anim.fade_out_ani);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in_ani);
        animation1.setAnimationListener(this);
        animation2.setAnimationListener(this);

        op1 = findViewById(R.id.first);
        op2 = findViewById(R.id.second);

        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainMenuActivity.class));
                overridePendingTransition(R.anim.fade_out_ani, R.anim.fade_in_ani);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        op1.startAnimation(animation1);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        //nothing
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if(c == 0){
            c++;
            op1.startAnimation(animation2);
        }
        else if(c == 1){
            c++;
            op1.setVisibility(View.INVISIBLE);
            op2.setVisibility(View.VISIBLE);
            op2.startAnimation(animation1);
        }
        else if(c == 2){
            c++;
            op2.startAnimation(animation2);
        }
        else{
            op2.setVisibility(View.INVISIBLE);
            startActivity(new Intent(MainActivity.this, MainMenuActivity.class));
            overridePendingTransition(R.anim.fade_out_ani, R.anim.fade_in_ani);
            finish();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        //nothing
    }
}