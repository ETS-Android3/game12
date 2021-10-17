package shaheer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;

import shaheer.tictactoe.R;

public class MainActivity extends AppCompatActivity {

    public EditText p1;

    public EditText p2;

    public Spinner levels;


     public CharSequence pl1 = "Player 1";

     public CharSequence pl2 = "Player 2";
       public CharSequence clone2;

        boolean player1 = true;

    boolean Plyrone;

    boolean e = true;

     boolean m = false;

     boolean h = false;

    boolean im = false;

    public CheckBox
            p0,
            p01,
             p02,

            p03,

            singleplayer,

    twoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        addItemToDifficultySpinner();

        p1 = (EditText) findViewById(R.id.playerone);

           p2 = (EditText) findViewById(R.id.playertwo);


        p0 = (CheckBox) findViewById(R.id.player1x);

           p01 = (CheckBox) findViewById(R.id.player1o);


         p02 = (CheckBox) findViewById(R.id.player2x);
          p03 = (CheckBox) findViewById(R.id.player2o);

            singleplayer = (CheckBox) findViewById(R.id.splayer);


            twoplayer = (CheckBox) findViewById(R.id.tplayer);
                p0.setOnClickListener(checkboxClickListener);

            p01.setOnClickListener(checkboxClickListener);

          p02.setOnClickListener(checkboxClickListener);

        p03.setOnClickListener(checkboxClickListener);

          singleplayer.setOnClickListener(checkboxClickListener);twoplayer.setOnClickListener(checkboxClickListener);

        levels.setEnabled(false);


        p0.setChecked(true);

        p03.setChecked(true);
        twoplayer.setChecked(true);


        p1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                pl1 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        p2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pl2 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void addItemToDifficultySpinner() {
        levels = (Spinner) findViewById(R.id.difficulty);

        List<String> list = new ArrayList<String>();

           list.add("Easy");list.add("Medium");list.add("Hard"); list.add("impossible");

           ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

               levels.setAdapter(dataAdapter);


               levels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                  @Override
                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                      String temp = parent.getItemAtPosition(position).toString();

                switch (temp) {
                    case "Easy":
                        e = true;
                        m = false;
                        h = false;
                        im = false;
                        break;

                    case "Medium":
                        e = false;
                        m = true;
                        h = false;
                        im = false;
                        break;

                    case "Hard":
                        e = false;
                        m = false;
                        h = true;
                        im = false;
                        break;

                       case "impossible":
                          e = false;
                          m = false;
                          h = false;
                          im = true;
                          break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                m = true;
                e = false;
                 h = false;
                 im = false;
             }
         });
    }




    View.OnClickListener checkboxClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean checked = ((CheckBox) view).isChecked();
               if  (checked) {
                 switch (view.getId()) {

                      case R.id.player1x:

                          p01.setChecked(false);

                          p02.setChecked(false);

                          p03.setChecked(true);
                        player1 = true;
                        break;

                       case R.id.player1o:

                          p0.setChecked(false);

                           p03.setChecked(false);
                           p02.setChecked(true);
                             player1 = false;
                          break;

                      case R.id.player2x:
                         p03.setChecked(false);
                           p0.setChecked(false);

                           p01.setChecked(true);
                          player1 = false;
                        break;

                       case R.id.player2o:
                          p02.setChecked(false);

                          p01.setChecked(false);

                         p0.setChecked(true);
                         player1 = true;
                          break;

                      case R.id.splayer:
                          twoplayer.setChecked(false);
                           Plyrone = true;
                          clone2 = pl2;
                         p2.setText("Computer");

                          p1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                          p1.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);


                         levels.setEnabled(true);
                         break;
                      case R.id.tplayer:
                          singleplayer.setChecked(false);

                         Plyrone = false;

                          p2.setText(clone2);

                         p1.setImeOptions(EditorInfo.IME_ACTION_NEXT);

                         p1.setImeActionLabel("NEXT", EditorInfo.IME_ACTION_NEXT);
                         levels.setEnabled(false);
                         break;
                 }

             } else {
                 switch (view.getId()) {
                     case R.id.player1x:
                         p01.setChecked(true);
                         p02.setChecked(true);
                        p03.setChecked(false);
                          player1 = false;
                         break;
                     case R.id.player1o:
                         p0.setChecked(true);
                         p03.setChecked(true);
                         p02.setChecked(false);
                        player1 = true;
                          break;
                     case R.id.player2x:
                         p03.setChecked(true);
                        p0.setChecked(true);
                         p01.setChecked(false);
                          player1 = true;
                        break;
                    case R.id.player2o:
                        p02.setChecked(true);
                        p01.setChecked(true);
                        p0.setChecked(false);
                        player1 = false;
                        break;
                    case R.id.splayer:
                         twoplayer.setChecked(true);
                          Plyrone = false;
                          p2.setText(clone2);
                           levels.setEnabled(false);
                          p1.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                         p1.setImeActionLabel("NEXT", EditorInfo.IME_ACTION_NEXT);
                         break;
                    case R.id.tplayer:
                         singleplayer.setChecked(true);
                         Plyrone = true;
                          p2.setText("computer");
                         p1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                         p1.setImeActionLabel("DONE", EditorInfo.IME_ACTION_DONE);
                           levels.setEnabled(true);
                            break;
                }

            }

        }

    };

    public void startgame(View view) {

             if (!Plyrone)
              if (pl2.length() == 0)
                pl2 = "player 2";
              if (pl1.length() == 0)
                   pl1 = "player 1";

        CharSequence[] players = {pl1, pl2};
        Intent i = new Intent(this, shaheer.levels.class);
        i.putExtra("easy", e);        i.putExtra("medium", m);

        i.putExtra("hard", h);    i.putExtra("impossible", im);
        i.putExtra("playersnames", players);        i.putExtra("player1ax", player1);
        i.putExtra("selectedsingleplayer", Plyrone);
        startActivity(i);
    }


}