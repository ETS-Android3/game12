package com.example.master.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.X;

public class player1 extends AppCompatActivity implements View.OnClickListener {

       public Button[][] b = new Button[3][3];
    public boolean firstturn = true;

     public int rC;

    public int p1P;

      public   int p2P;

    public TextView tVP1;

        public TextView tVP2;
    @Override
      protected void onCreate(Bundle sIS) {
             super.onCreate(sIS);
        setContentView(R.layout.activity_player1);

        getSupportActionBar().hide();
        tVP1 =   findViewById(R.id.p1);
            tVP2 = findViewById(R.id.p2);

           for (int i = 0; i < 3; i++) {


              for (int j  = 0; j < 3; j++) {

                  String buttonID = "button_" + i + j;
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());

                  b[i][j] = findViewById(resID);

                b[i][j].setOnClickListener(this);
               }
        }
           Button buttonReset = findViewById(R.id.reset);

               buttonReset.setOnClickListener(new View.OnClickListener() {

              @Override
               public void onClick(View v) {
                rG();
            }
        });
    }

    @Override
       public void  onClick(View v) {
             if (!((Button) v).getText().toString().equals("")) {

             return;
          }
               if (firstturn) {

                 ((Button) v).setText("X");
                   Toast.makeText(this, "Player O turn!", Toast.LENGTH_SHORT).show();

           } else {

             ((Button) v).setText("O");

                   Toast.makeText(this, "Player X turn!", Toast.LENGTH_SHORT).show();

               }

            rC++;
                 if (cFW()) {
                         if (firstturn) {

                       Wins();


                         } else {
                                 Wins2();
                             }


                 } else if (rC == 9) {
            draw();
          } else {

                     firstturn = !firstturn;
        }
    }



    private boolean cFW() {

        String[][] field = new String[3][3];
                  for (int i = 0; i < 3; i++) {

                   for (int j = 0; j < 3; j++) {
                  field[i][j] = b[i][j].getText().toString();
             }
         }
         for (int i = 0; i < 3; i++) {

            if (field[i][0].equals(field[i][1])

                      && field[i][0].equals(field[i][2])

                       && !field[i][0].equals("")) {
                 return true;
              }
        }
             for (int i = 0; i < 3; i++) {
               if (field[0][i].equals(field[1][i])

                   && field[0][i].equals(field[2][i])

                   && !field[0][i].equals("")) {
                       return true;
            }
         }
          if (field[0][0].equals(field[1][1])

             && field[0][0].equals(field[2][2])
                   && !field[0][0].equals("")) {

              return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])

                  && !field[0][2].equals("")) {

                return true;
        }
          return false;
    }
        public void Wins() {
          p1P++;

           Toast.makeText(this, "Player 1 won!", Toast.LENGTH_SHORT).show();

            uPT();
              rB();
    }

      public void Wins2() {
           p2P++;

         Toast.makeText(this, "Player 2 won!", Toast.LENGTH_SHORT).show();

          uPT();
                 rB();
    }
    public void draw() {
           Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();

            rB();
    }


        public void uPT() {
                tVP1.setText("X : " + p1P);

             tVP2.setText("O : " + p2P);
    }
             private void rB() {

               for (int i = 0; i < 3; i++) {

             for (int j = 0; j < 3; j++) {
                b[i][j].setText("");
            }
        }

        rC = 0;


        firstturn = true;
    }

    public void rG() {

        p1P = 0;
          p2P = 0;


         uPT();
        rB();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
          super.onSaveInstanceState(outState);

         outState.putInt("rC", rC);
        outState.putInt("p1P", p1P);

          outState.putInt("p2P", p2P);

        outState.putBoolean("p1T", firstturn);
    }
    @Override
     protected void onRestoreInstanceState(Bundle sIS) {

        super.onRestoreInstanceState(sIS);

          rC = sIS.getInt("rdCt");

           p1P = sIS.getInt("p1P");
             p2P = sIS.getInt("p2P");


        firstturn = sIS.getBoolean("p1T");
    }
}