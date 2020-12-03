package com.example.tapfighters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CharacterSelectOffline extends AppCompatActivity{

    private LinearLayout characterLayout, selection;
    private ImageView p1, p2, vs, p1character, p2character;
    private int screenX, screenY, c = 0, p1c = 0, p2c = 0;
    private boolean running = true, ready1 = false, ready2 = false, firstTime = true;
    private UpdateVS updateVS = null;
    private int[] characters= { R.drawable.pr, R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4};
    private String difficulty = "easy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select_offline);

        characterLayout = findViewById(R.id.charactersLayout);
        selection = findViewById(R.id.charactersSelectLayout);

        Point p = new Point();// (x, y)
        getWindowManager().getDefaultDisplay().getSize(p);// makes p(x,y) -> p(width, height)

        screenX = p.x;
        screenY = p.y;

        System.out.println(screenX + " " + screenY);

        resizeLayouts();

        p1 = findViewById(R.id.p1Image);
        p2 = findViewById(R.id.p2Image);
        vs = findViewById(R.id.vsImage);
        p1character = findViewById(R.id.p1Character);
        p2character = findViewById(R.id.p2Character);

        findViewById(R.id.arrowR1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1c == 4) {
                    p1c = 0;
                }
                else {
                    p1c ++;
                }
                p1character.setBackgroundResource(characters[p1c]);
            }
        });
        findViewById(R.id.arrowL1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1c == 0)
                    p1c = 4;
                else
                    p1c --;
                p1character.setBackgroundResource(characters[p1c]);
            }
        });

        findViewById(R.id.arrowR2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p2c == 4) {
                    p2c = 0;
                }
                else {
                    p2c ++;
                }
            }
        });
        findViewById(R.id.arrowL2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p2c == 0)
                    p2c = 4;
                else
                    p2c --;
            }
        });

        findViewById(R.id.chooseP1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ready1 = !ready1;
                Button a = findViewById(R.id.chooseP1);
                if(ready2 && ready1){
                    findViewById(R.id.ready).setEnabled(true);
                }
                else {
                    findViewById(R.id.ready).setEnabled(false);
                    if(!a.getText().equals("select")){
                        a.setText("select");
                        p1.setBackgroundResource(R.drawable.pd);
                    }
                    else {
                        a.setText("ready");
                        p1.setBackgroundResource(characters[p1c]);
                    }
                }
            }
        });
        findViewById(R.id.chooseP2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ready2 = !ready2;
                Button a = findViewById(R.id.chooseP2);
                if(ready2 && ready1){
                    findViewById(R.id.ready).setEnabled(true);
                }
                else {
                    findViewById(R.id.ready).setEnabled(false);
                    if(!a.getText().equals("select")){
                        a.setText("select");
                        p2.setBackgroundResource(R.drawable.pd);
                    }
                    else {
                        a.setText("ready");
                        p2.setBackgroundResource(characters[p2c]);
                    }
                }
            }
        });

        findViewById(R.id.ready).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterSelectOffline.this, GameActivity.class);
                intent.putExtra("player one choice", p1c);
                intent.putExtra("player two choice", p2c);
                intent.putExtra("dif", difficulty);
                startActivity(intent);
                finish();
            }
        });

        updateVS = new UpdateVS(c, 333, 333, vs);
        updateVS.start();
    }



    private void resizeLayouts() {
        characterLayout.setLayoutParams(new LinearLayout.LayoutParams(screenX,screenY/2));
        selection.setLayoutParams(new LinearLayout.LayoutParams(screenX, screenY/2));
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.intent_transition_start, R.anim.intent_transition_end);
    }

    public void getButton(View v) {
        if(v.getId() == R.id.radioButtonEasy){
            difficulty = "easy";
        }
        else if(v.getId() == R.id.radioButtonMedium){
            difficulty = "medium";
        }
        else{
            difficulty = "hard";
        }
    }
}