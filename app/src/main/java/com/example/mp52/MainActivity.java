package com.example.mp52;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] WORDS ={"Tiger","Pigeon","Frog"};
    private static final int REQ_CODE_ANS = 2468;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attach reference list to mylist
        ListView list = (ListView) findViewById(R.id.mylist);

        final Intent forwardIntent = new Intent(this,ImgDisp.class);

        //Create adapter and attach to WORDS
        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,WORDS);

        //Use myadapter as input to list
        list.setAdapter(myadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                forwardIntent.putExtra("animal",word);

                // Want to return a result
                startActivityForResult(forwardIntent,REQ_CODE_ANS);
            }
        });


        Button buttonOne = (Button) findViewById(R.id.resetButton);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView textView = findViewById(R.id.Scoreboard);
                textView.setText("0");
            }
        });
    }

    //BackIntent returns control back here
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode==REQ_CODE_ANS) {
            String val = intent.getStringExtra("family");

            if(val.equalsIgnoreCase("1"))
            {
                Toast.makeText(MainActivity.this, "Good job!", Toast.LENGTH_SHORT).show();

                TextView textView = findViewById(R.id.Scoreboard);
                String myText = (String) textView.getText();
                int myText_int = Integer.parseInt(myText);
                myText_int++;
                textView.setText(String.valueOf(myText_int));
            }
            else
            {
                Toast.makeText(MainActivity.this, "Try again!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}