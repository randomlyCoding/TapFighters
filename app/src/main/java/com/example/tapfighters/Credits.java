package com.example.tapfighters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Credits extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_credits);
        tv = findViewById(R.id.Credits);
        tv.setText("general: " + "\n" + "this project was made possible with android studio");
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.voiceCredits){
            tv.setText("voice actors: " + "\n" + "X: Foad Moalem." + "\n" + "megeta: fadi" + "\n" + "dragonite: zimpro" + "\n" + "Y: ");
        }
        else if(item.getItemId()==R.id.spritesCredit){
            tv.setText("sprites: " + "\n" + "all sprites were made by Foad Moalem");
        }
        else if(item.getItemId()==R.id.generalCredits){
            tv.setText("general: " + "\n" + "this project was made possible with android studio");
        }
        return true;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.intent_transition_start, R.anim.intent_transition_end);
    }
}