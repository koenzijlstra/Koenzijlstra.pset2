package com.example.koen.koenzijlstrapset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // when start button is pressed, go to the second activity (that lets user fill in the words)
    public void getsecondactivity(View view){
        Intent secondscreenintent = new Intent(this, secondscreen.class );
        startActivity(secondscreenintent);
        // finish();
    }
}

