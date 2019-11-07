package com.example.myapplication1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static EditText editText;
    protected SharedPreferences prefs;
    protected String previous;
    protected Button mainPageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.emailText);

        prefs = getSharedPreferences("FileName", MODE_PRIVATE);
        previous = prefs.getString("ReserveName", "Default Value");

        editText.setText(previous);


        mainPageButton = (Button)findViewById(R.id.LoginButton);
        if(mainPageButton !=null){
            mainPageButton.setOnClickListener(n -> {
                Intent goToPage1 = new Intent(MainActivity.this, ProfileActivity.class);

                goToPage1.putExtra("email",editText.getText().toString());

                startActivityForResult(goToPage1,30);
            });
        }

    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.v("FileName","onPause1");
        prefs = getSharedPreferences("FileName", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ReserveName", editText.getText().toString());

        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
