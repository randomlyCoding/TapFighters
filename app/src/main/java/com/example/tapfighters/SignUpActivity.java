package com.example.tapfighters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private ImageView profilePic,lastPicImage;
    private FirebaseAuth mAuth;
    private EditText pass, mail, name;
    private TextView errMsg;
    private Dialog images;
    private Uri lastPic;
    private final int GALLERY = 0, CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        images = new Dialog(this);
        images.setCancelable(true);
        images.setContentView(R.layout.activity_profile_pic_select);

        profilePic = findViewById(R.id.profilePicImages);
        name = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        errMsg = findViewById(R.id.signupErrorText);

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                images.show();
            }
        });

        images.findViewById(R.id.customPic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SignUpActivity.this);
                alert.setTitle("choose one");
                alert.setMessage("");
                alert.setPositiveButton("camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        images.cancel();
                        Intent open = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(open, CAMERA);
                    }
                });
                alert.setNegativeButton("gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        images.cancel();
                        Intent open = new Intent();
                        open.setAction(Intent.ACTION_GET_CONTENT);
                        open.setType("image/*");
                        startActivityForResult(Intent.createChooser(open, "Select A Profile Picture"), GALLERY);
                    }
                });
                alert.create().show();
            }
        });

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.signupButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(pass, mail, name);
            }
        });

    }

    private void createUser(EditText pass, EditText mail, EditText name) {

        mAuth.createUserWithEmailAndPassword(mail.getText().toString(), pass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("foad", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification();
                            startActivity(new Intent(SignUpActivity.this, WaitingForConfActivity.class));
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("foad", "" + task.getException());
                            errMsg.setError(task.getException().toString());
                            Toast.makeText(SignUpActivity.this, ""+errMsg.getText(), Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == Activity.RESULT_OK && data != null) {
                if(requestCode == GALLERY) {
                    lastPic = data.getData();
                    profilePic.setImageURI(lastPic);
                    lastPicImage = images.findViewById(R.id.lastPic);
                    lastPicImage.setImageURI(lastPic);
                }
                else if(requestCode == CAMERA) {
                    profilePic.setImageBitmap((Bitmap) data.getExtras().get("data"));
                    lastPicImage = images.findViewById(R.id.lastPic);
                    lastPicImage.setImageBitmap((Bitmap) data.getExtras().get("data"));
                }
            }
    }

    @Override
    public void finish() {
        super.finish();
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        overridePendingTransition(R.anim.intent_transition_start, R.anim.intent_transition_end);
    }
}