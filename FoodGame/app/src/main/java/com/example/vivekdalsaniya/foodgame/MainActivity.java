package com.example.vivekdalsaniya.foodgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    ArrayList<String> Fooditem=new ArrayList<String>();
    Queue<String> Computer;
    Queue<String> Key = new LinkedList<String>();
    Queue<String> Player = new LinkedList<String>();
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    TextView item_t,score_t;
    Random r1=new Random();
    int score=0,flag=0,count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        b10=(Button)findViewById(R.id.button10);
        item_t=(TextView)findViewById(R.id.tv1);
        score_t=(TextView)findViewById(R.id.tv2);
        this.setDisable();
        Fooditem.add("Gathiya");
        Fooditem.add("Jalebi");
        Fooditem.add("Chips");
        Fooditem.add("Locho");
        Fooditem.add("Alupuri");
        Fooditem.add("Khaman");
        Fooditem.add("Menduvda");
        Fooditem.add("Idli");
        Fooditem.add("Pova");
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b10.setVisibility(View.GONE);
                computerTurn();
            }
        });


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

    public void setEnabled1(){
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);


    }

    public void setDisable(){
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    public void computerTurn(){
        Toast.makeText(getApplicationContext(),"heloo",Toast.LENGTH_SHORT).show();
        this.setDisable();
        System.out.println("nishit" + Fooditem.size());

        int q=r1.nextInt(Fooditem.size());
        Log.d("Rand", "q " + q);
        String itemName=Fooditem.get(q);
        item_t.setText("You Ate " + itemName);
        Key.add(itemName);
        Player.clear();
        this.playerTurn();
    }

    public void playerTurn(){
        this.setEnabled1();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"asasas",Toast.LENGTH_SHORT).show();
                Player.add("Gathiya");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Jalebi");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Chips");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Locho");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Alupuri");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Khaman");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Menduvda");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Idli");
                count++;
                if(count==Key.size())
                    mid();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "asasas", Toast.LENGTH_SHORT).show();
                Player.add("Pova");
                count++;
                if(count==Key.size())
                    mid();
            }
        });

    }

    public Boolean check(){
        if(Key.equals(Player))
            return true;
        else
            return false;
    }

    public void mid(){
            this.setDisable();
            Boolean Answer = this.check();
            if (Answer == true) {
                //Proceed
                count=0;
                System.out.println("bbbbbbbbbbbbbbbb"+Player.size());
                score++;
                score_t.setText("Your score is :"+ score);
                this.computerTurn();
            } else {
                //sorry
                //print your sco
                System.out.println("bbbb22222222222222222"+Player.size());

                Intent i1=new Intent(getApplicationContext(),LastActivity.class);
                //
                Log.d("score",""+score);
                i1.putExtra("score",""+score);
                startActivity(i1);
            }
        }

}
