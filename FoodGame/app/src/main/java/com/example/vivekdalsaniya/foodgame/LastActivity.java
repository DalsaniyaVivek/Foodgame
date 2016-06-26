package com.example.vivekdalsaniya.foodgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Created by Vivek Dalsaniya on 4/16/2016.
 */
public class LastActivity extends Activity {

    int score2=0;
    MainActivity m1 = new MainActivity();
    String status;
    TextView scoreFinal_t,status_t;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lastactivity);
        scoreFinal_t=(TextView)findViewById(R.id.tv3);
        status_t=(TextView)findViewById(R.id.tv4);

       // System.out.println("score "+m1.score);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String score = extras.getString("score");
            System.out.println("hashahhshasa"+score);
            score2 = Integer.parseInt(score);
        }



       if(score2<5){
            status="Poor";
        }
        else if(score2<10){
            status="Average";
        }
        else if(score2<15){
            status="Good";
        }
        else if(score2<20){
            status="Excellent";
        }
        else {
            status="Can't Judge";
        }
        scoreFinal_t.setText("Your Final Score Is: " + score2);

         status_t.setText("Your Perfomence Is: " + status);
    }
}
