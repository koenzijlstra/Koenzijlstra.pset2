package com.example.koen.koenzijlstrapset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;

public class secondscreen extends AppCompatActivity {

    Story tarzan;
    InputStream stream;
    EditText wordinput;
    TextView remainingTV;
    int remains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);
        createstory();
    }

    public void createstory () {

        stream = this.getResources().openRawResource(R.raw.madlib1_tarzan);
        tarzan = new Story(stream);
        remains = tarzan.getPlaceholderRemainingCount();

        // create the text for textview "wordsremaining". shows the amount of words that still
        // need to be f(illed in (getPlaceholderRemainingCount)
        remainingTV = (TextView) findViewById(R.id.remaining);
        remainingTV.setText(remains + "word(s) left");

        // create hint in textbox
        wordinput = (EditText) findViewById(R.id.editText);
        wordinput.setHint(tarzan.getNextPlaceholder());
        wordinput.setVisibility(View.VISIBLE);
    }


    public void fillwords (View view){

        // when there are still words to fill in, so isFilledin is false: retreive words from user,
        // set the hint of the edittext. Errorcheck if the word is not zero, if not fill the word
        // in to the place of placeholder of story.
        if (!tarzan.isFilledIn()){

            // same as before, get the edit text widget
            wordinput = (EditText) findViewById(R.id.editText);
            String word = wordinput.getText().toString();

            // clear the filled in word
            wordinput.setText("");

            // if a word is given by user, so length != 0 => fill the word in into the story, and
            // decrease the words that remain to be filled in
            if (word.length() != 0){
                // fill the word into tarzan
                tarzan.fillInPlaceholder(word);
                // change the remaining words text view
                int remains = tarzan.getPlaceholderRemainingCount();
                remainingTV.setText(remains + "word(s) left");

                // set the hint to the next placeholder (e.g. noun)
                wordinput.setHint(tarzan.getNextPlaceholder());

            }
            // else (when the length of the word is 0) toast
            else{
                Toast toast = Toast.makeText(this, "Please enter a word", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        if (tarzan.isFilledIn()){
            // when all words are filled in, go to last activity and close current one
            String fullstory = tarzan.toString();
            Intent gotostory = new Intent(this, readstory.class);
            gotostory.putExtra("storyretrieval", fullstory);
            startActivity(gotostory);
            finish();
        }
    }
}

