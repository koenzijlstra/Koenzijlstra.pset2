package com.example.koen.koenzijlstrapset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class secondscreen extends AppCompatActivity {

    Story tarzan;
    InputStream stream;
    EditText wordinput;
    TextView remainingTV;

    // create a boolean, false if the story has not been constructed
    // true if story is constructed
    boolean storyinit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);
    }



// construct a story

    public void submission(View view){

        if (!storyinit) {
            stream = this.getResources().openRawResource(R.raw.madlib1_tarzan);
            tarzan = new Story(stream);


            // create the text for textview "wordsremaining". shows the amount of words that still
            // need to be filled in (getPlaceholderRemainingCount)
            int remains = tarzan.getPlaceholderRemainingCount();
            remainingTV = (TextView) findViewById(R.id.remaining);
            remainingTV.setText(remains + "word(s) left");


            wordinput = (EditText) findViewById(R.id.editText);
            wordinput.setHint(tarzan.getNextPlaceholder());
            wordinput.setVisibility(View.VISIBLE);
            storyinit = true;
        }
        if (tarzan.isFilledIn()){

            String fullstory = tarzan.toString();

        }



        // Check if all words are filled in





    }


// show remaining words to fill in on screen moet eigenlijk android:hint zijn
//    int remainingwords = getPlaceholderRemainingCount(tarzan)
//    TextView tv = (TextView) findViewById(R.id.remaining);
//    tv.setText(remainingwords + "word(s) left")
//    }


// edit text
//    fillInPlaceholder(String word)



    // if all placeholders are filled, go to third and final activity. \
//    if isFilledIn(tarzan) {
//        Intent readstoryintent = new Intent(this, readstory.class);
//        startActivity(readstoryintent);
//    }


}

