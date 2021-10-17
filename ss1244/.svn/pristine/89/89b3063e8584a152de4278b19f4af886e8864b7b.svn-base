package com.example.master.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tictactoe extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(sIS);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tictactoe);
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_tictactoe);

  //textView = findViewById(R.id.textView);
    //    kotlin_btn = findViewById(R.id.kotlin_btn);

        //





        Button b = (Button) findViewById(R.id.button);

            Button b1 = (Button) findViewById(R.id.button1);

    //    Button b2 = (Button) findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent first = new Intent(tictactoe.this, player1.class);
                     startActivity(first);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent sec = new Intent(tictactoe.this, MainActivity.class);

                     startActivity(sec);

            }
        });


    }
}

