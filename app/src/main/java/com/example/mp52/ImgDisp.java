package com.example.mp52;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ImgDisp extends AppCompatActivity {

    private static final String[] WORDS ={"Tiger","Pigeon","Frog"};
    private static final String[] ANSWER ={"Mammal","Bird","Amphibian"};
    private int choicePos; // Position of user choice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_disp);

        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("animal");
        ImageView img = (ImageView) findViewById(R.id.myimg);

        EditText anstxt = (EditText) findViewById(R.id.myans);
        anstxt.setHint("Enter Text ");

        if (extra.equals(WORDS[0])) {
            img.setImageResource(R.drawable.tiger);
            choicePos = 0;
        }

        if (extra.equals(WORDS[1])) {
            img.setImageResource(R.drawable.pigeon);
            choicePos = 1;
        }

        if (extra.equals(WORDS[2])) {
            img.setImageResource(R.drawable.frog);
            choicePos = 2;
        }
    }

    public void myclick (View view){

        EditText anstxt = (EditText) findViewById(R.id.myans);
        String ans;

        //Returning the answer back to the calling activity
        Intent backIntent = new Intent();
        ans = anstxt.getText().toString();

        if(ANSWER[choicePos].equalsIgnoreCase(ans))
        {
            backIntent.putExtra("family", "1");
        }
        else
        {
            backIntent.putExtra("family", "0");
        }
        setResult(RESULT_OK, backIntent);

        finish();
    }
}