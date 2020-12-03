                                      package com.example.tapfighters;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

                                      public class MainMenuActivity extends AppCompatActivity{

    private MediaPlayer backgroundmusic;
    private Dialog options, sound;
    public static float SFX = 1, VOICE = 1, MUSIC = 1;
    private TextView SFX_prec, VOICE_prec, MUSIC_prec;
    private ImageView[] SFXbnts = new ImageView[11], VOICEbnts = new ImageView[11], MUSICbnts = new ImageView[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backgroundmusic = new MediaPlayer().create(MainMenuActivity.this, R.raw.p5); 
        backgroundmusic.setVolume(MUSIC, MUSIC);
        backgroundmusic.start();



        options = new Dialog(this);
        options.setCancelable(false);
        options.setContentView(R.layout.activity_options_popup);
        //makes the corners not white
        options.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        sound = new Dialog(this);
        sound.setCancelable(false);
        sound.setContentView(R.layout.activity_sound_popup);
        //makes the corners not white
        sound.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        setContentView(R.layout.activity_main_menu);
        findViewById(R.id.offlinePlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, CharacterSelectOffline.class));
                overridePendingTransition(R.anim.intent_transition_start, R.anim.intent_transition_end);
            }
        });

        findViewById(R.id.options).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options.show();
            }
        });
        options.findViewById(R.id.CloseOptions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options.cancel();
            }
        });
        options.findViewById(R.id.SoundOptions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.show();
            }
        });
        options.findViewById(R.id.CreditsOptions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, Credits.class));
                overridePendingTransition(R.anim.intent_transition_start, R.anim.intent_transition_end);
            }
        });
        options.findViewById(R.id.AccountOptions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
                overridePendingTransition(R.anim.intent_transition_start, R.anim.intent_transition_end);
            }
        });
        sound.findViewById(R.id.ReturnSoundBnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.cancel();
            }
        });

        findViewById(R.id.onlinePlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "online is not possible without unity", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.charShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, ShowcaseActivity.class));
            }
        });

        optionSet();

    }

    @Override
    protected void onPause() {
        super.onPause();
        backgroundmusic.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundmusic.start();
    }

    private void optionSet() {

        //SFX
        SFX_prec = sound.findViewById(R.id.SFX_perc);

        SFXbnts[0] = sound.findViewById(R.id.SFXSoundBtn0);
        SFXbnts[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 11; i++) {
                    SFX_prec.setText("SFX volume:         0%");
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                    SFX = 0;
                }
            }
        });
        SFXbnts[1] = sound.findViewById(R.id.SFXSoundBtn10);
        SFXbnts[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.1f;
                for(int i = 10; i > 1; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 1; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
                SFX_prec.setText("SFX volume:        10%");
            }
        });
        SFXbnts[2] = sound.findViewById(R.id.SFXSoundBtn20);
        SFXbnts[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.2f;
                SFX_prec.setText("SFX volume:        20%");
                for(int i = 10; i > 2; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 2; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[3] = sound.findViewById(R.id.SFXSoundBtn30);
        SFXbnts[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.3f;
                SFX_prec.setText("SFX volume:        30%");
                for(int i = 10; i > 3; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 3; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[4] = sound.findViewById(R.id.SFXSoundBtn40);
        SFXbnts[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.4f;
                SFX_prec.setText("SFX volume:        40%");
                for(int i = 10; i > 4; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 4; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[5] = sound.findViewById(R.id.SFXSoundBtn50);
        SFXbnts[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.5f;
                SFX_prec.setText("SFX volume:        50%");
                for(int i = 10; i > 5; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 5; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[6] = sound.findViewById(R.id.SFXSoundBtn60);
        SFXbnts[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.6f;
                SFX_prec.setText("SFX volume:        60%");
                for(int i = 10; i > 6; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 6; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[7] = sound.findViewById(R.id.SFXSoundBtn70);
        SFXbnts[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.7f;
                SFX_prec.setText("SFX volume:        70%");
                for(int i = 10; i > 7; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 7; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[8] = sound.findViewById(R.id.SFXSoundBtn80);
        SFXbnts[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.8f;
                SFX_prec.setText("SFX volume:        80%");
                for(int i = 10; i > 8; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 8; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[9] = sound.findViewById(R.id.SFXSoundBtn90);
        SFXbnts[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SFX = 0.9f;
                SFX_prec.setText("SFX volume:        90%");
                for(int i = 10; i > 9; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 9; i >= 0; i--){
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        SFXbnts[10] = sound.findViewById(R.id.SFXSoundBtn100);
        SFXbnts[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 11; i++) {
                    SFX_prec.setText("SFX volume:    100%");
                    SFXbnts[i].setImageResource(R.drawable.optionsbuttonon);
                    SFX = 1.0f;
                }
            }
        });

        //voices

        VOICE_prec = sound.findViewById(R.id.VOICE_perc);

        VOICEbnts[0] = sound.findViewById(R.id.VOICESoundBtn0);
        VOICEbnts[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 11; i++) {
                    VOICE_prec.setText("VOICE volume:       0%");
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                    VOICE = 0;
                }
            }
        });
        VOICEbnts[1] = sound.findViewById(R.id.VOICESoundBtn10);
        VOICEbnts[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.1f;
                for(int i = 10; i > 1; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 1; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
                VOICE_prec.setText("VOICE volume:     10%");
            }
        });
        VOICEbnts[2] = sound.findViewById(R.id.VOICESoundBtn20);
        VOICEbnts[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.2f;
                VOICE_prec.setText("VOICE volume:     20%");
                for(int i = 10; i > 2; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 2; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[3] = sound.findViewById(R.id.VOICESoundBtn30);
        VOICEbnts[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.3f;
                VOICE_prec.setText("VOICE volume:     30%");
                for(int i = 10; i > 3; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 3; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[4] = sound.findViewById(R.id.VOICESoundBtn40);
        VOICEbnts[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.4f;
                VOICE_prec.setText("VOICE volume:     40%");
                for(int i = 10; i > 4; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 4; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[5] = sound.findViewById(R.id.VOICESoundBtn50);
        VOICEbnts[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.5f;
                VOICE_prec.setText("VOICE volume:     50%");
                for(int i = 10; i > 5; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 5; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[6] = sound.findViewById(R.id.VOICESoundBtn60);
        VOICEbnts[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.6f;
                VOICE_prec.setText("VOICE volume:     60%");
                for(int i = 10; i > 6; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 6; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[7] = sound.findViewById(R.id.VOICESoundBtn70);
        VOICEbnts[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.7f;
                VOICE_prec.setText("VOICE volume:     70%");
                for(int i = 10; i > 7; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 7; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[8] = sound.findViewById(R.id.VOICESoundBtn80);
        VOICEbnts[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.8f;
                VOICE_prec.setText("VOICE volume:     80%");
                for(int i = 10; i > 8; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 8; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[9] = sound.findViewById(R.id.VOICESoundBtn90);
        VOICEbnts[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VOICE = 0.9f;
                VOICE_prec.setText("VOICE volume:     90%");
                for(int i = 10; i > 9; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 9; i >= 0; i--){
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        VOICEbnts[10] = sound.findViewById(R.id.VOICESoundBtn100);
        VOICEbnts[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 11; i++) {
                    VOICE_prec.setText("VOICE volume:    100%");
                    VOICEbnts[i].setImageResource(R.drawable.optionsbuttonon);
                    VOICE = 1.0f;
                }
            }
        });

        // Music

        MUSIC_prec = sound.findViewById(R.id.MUSIC_perc);

        MUSICbnts[0] = sound.findViewById(R.id.MUSICSoundBtn0);
        MUSICbnts[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 11; i++) {
                    MUSIC_prec.setText("MUSIC volume:       0%");
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                    MUSIC = 0;
                }
            }
        });
        MUSICbnts[1] = sound.findViewById(R.id.MUSICSoundBtn10);
        MUSICbnts[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.1f;
                for(int i = 10; i > 1; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 1; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
                MUSIC_prec.setText("MUSIC volume:     10%");
            }
        });
        MUSICbnts[2] = sound.findViewById(R.id.MUSICSoundBtn20);
        MUSICbnts[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.2f;
                MUSIC_prec.setText("MUSIC volume:     20%");
                for(int i = 10; i > 2; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 2; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[3] = sound.findViewById(R.id.MUSICSoundBtn30);
        MUSICbnts[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.3f;
                MUSIC_prec.setText("MUSIC volume:     30%");
                for(int i = 10; i > 3; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 3; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[4] = sound.findViewById(R.id.MUSICSoundBtn40);
        MUSICbnts[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.4f;
                MUSIC_prec.setText("MUSIC volume:     40%");
                for(int i = 10; i > 4; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 4; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[5] = sound.findViewById(R.id.MUSICSoundBtn50);
        MUSICbnts[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.5f;
                MUSIC_prec.setText("MUSIC volume:     50%");
                for(int i = 10; i > 5; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 5; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[6] = sound.findViewById(R.id.MUSICSoundBtn60);
        MUSICbnts[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.6f;
                MUSIC_prec.setText("MUSIC volume:     60%");
                for(int i = 10; i > 6; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 6; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[7] = sound.findViewById(R.id.MUSICSoundBtn70);
        MUSICbnts[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.7f;
                MUSIC_prec.setText("MUSIC volume:     70%");
                for(int i = 10; i > 7; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 7; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[8] = sound.findViewById(R.id.MUSICSoundBtn80);
        MUSICbnts[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.8f;
                MUSIC_prec.setText("MUSIC volume:     80%");
                for(int i = 10; i > 8; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 8; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[9] = sound.findViewById(R.id.MUSICSoundBtn90);
        MUSICbnts[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MUSIC = 0.9f;
                MUSIC_prec.setText("MUSIC volume:     90%");
                for(int i = 10; i > 9; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonoff);
                }
                for(int i = 9; i >= 0; i--){
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                }
            }
        });
        MUSICbnts[10] = sound.findViewById(R.id.MUSICSoundBtn100);
        MUSICbnts[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 11; i++) {
                    MUSIC_prec.setText("MUSIC volume:    100%");
                    MUSICbnts[i].setImageResource(R.drawable.optionsbuttonon);
                    MUSIC = 1.0f;
                }
            }
        });
    }
}