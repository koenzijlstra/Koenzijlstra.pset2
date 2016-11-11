package com.example.koen.koenzijlstrapset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class readstory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readstory);
        readtarzan();
    }

    public void readtarzan (){
        Bundle extras = getIntent().getExtras();
        String tarzanstory = extras.getString("storyretrieval");

        TextView storytv = (TextView) findViewById(R.id.storyoftarzan);
        storytv.setText(tarzanstory);
    }
}
