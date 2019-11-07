package com.example.myapplication1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    protected EditText nameText;
    protected ImageButton mImageButton;
    public static final String ACTIVITY_NAME = "ProfileActivity";
    protected Button goToChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(ACTIVITY_NAME, "In function:" + "onCreate");
        setContentView(R.layout.profile_activity);


        nameText = findViewById(R.id.NameText);

        Intent dataFromPreviousPage = getIntent();
        String emailFromPage1 = dataFromPreviousPage.getStringExtra("email");

        TextView email = findViewById(R.id.emailText2);
        email.setText(emailFromPage1);

        mImageButton =  (ImageButton)findViewById(R.id.ImageButton);
        if(mImageButton !=null) {
            mImageButton.setOnClickListener(n -> {
                {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }

            });
        }

        goToChat = (Button)findViewById(R.id.gotochatbutton);
        if(goToChat != null){
            goToChat.setOnClickListener(n -> {
                {
                    Intent goToChatRoom = new Intent(ProfileActivity.this,ChatRoomActivity.class);

                    startActivity(goToChatRoom);
                }
            });
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
        }
    }
    @Override
    protected void onStart() {
        Log.e(ACTIVITY_NAME, "In function:" + "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(ACTIVITY_NAME, "In function:" + "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(ACTIVITY_NAME, "In function:" + "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(ACTIVITY_NAME, "In function:" + "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(ACTIVITY_NAME, "In function:" + "onDestroy");
        super.onDestroy();
    }
}

