package com.example.vivekdalsaniya.comodoro;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button b1,b3,b4;
    int const1=0;
    TextView t1,t2,t3,t4;
    String full="";
    int var1=0;
    CountDownTimer waittime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        t1=(TextView)findViewById(R.id.tasks);
        t3=(TextView)findViewById(R.id.minutes);
        t4=(TextView)findViewById(R.id.seconds);
        b1=(Button)findViewById(R.id.addtask);
        b3=(Button)findViewById(R.id.start);
        b4=(Button)findViewById(R.id.end);

        t3.setText("25");
        t4.setText("00");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(context);
                final View promptsView = li.inflate(R.layout.promt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);
                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text


                                        final String temp = userInput.getText().toString();
                                        Spannable temp1 = new SpannableString(temp);
                                        temp1.setSpan(new ForegroundColorSpan(getRandomColor()), 0, temp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        full = full + "\n" + temp1;
                                        t1.setText(full);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnesecondInterval();
                b3.setEnabled(false);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(waittime != null) {
                    waittime.cancel();
                    waittime = null;
                }
                t3.setText("25");
                t4.setText("00");
                b3.setVisibility(View.VISIBLE);
            }
        });


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void OnesecondInterval(){


            waittime =new CountDownTimer(1500000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    t3.setText(""+ TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished));
                    t4.setText(""+(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))%60);
                }

                @Override
                public void onFinish() {
                    t3.setText("00");
                    t4.setText("00");
                    b3.setText("Start Break Time");
                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                         waittime=new CountDownTimer(180000,1000) {
                             @Override
                             public void onTick(long millisUntilFinished) {
                                 t3.setText(""+ TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished));
                                 t4.setText(""+(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))%60);
                             }

                             @Override
                             public void onFinish() {
                                 if(var1==4){
                                     return;
                                 }
                                 else
                                 {
                                     OnesecondInterval();
                                 }
                             }
                         }.start();
                        }
                    });

                }
            }.start();

    }

    public int getRandomColor(){
        const1++;
        if(const1%3==0)
            return Color.parseColor("#ff9800");
        else if(const1%3==1)
            return Color.parseColor("#795548");
        else
            return Color.parseColor("#4caf50");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
