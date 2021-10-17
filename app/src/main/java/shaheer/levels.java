package shaheer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import shaheer.tictactoe.R;

public class levels extends AppCompatActivity {
/*
In this class there are easy, medium, hard, and impossible difficulty levels.
There are two options for the player single and multiplayer.
 */
    boolean e;
    boolean m;

    boolean h;

    boolean impossible;

    Random r = new Random();

    int flag = 0,
            ax = 10,
            zero = 1,

    sensorflag = 0,

    win = 0, i,

    game = 1,

    prevrow, prevcol;

    int summ = 0, flag1 = 0, night = 0, res = 1,
            currentgamedonechecker = 0;

    int score1 = 0, score2 = 0, drawchecker = 0;

    static int[][] t = new int[3][3];

    int[] sum = new int[8];

    static int[][] bp = new int[3][3];

    boolean p01;

    boolean p02;

    TextView p1;

    TextView p2;

    CharSequence pl1 = "Player 1";

    CharSequence pl2 = "Player 2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

/*

 */
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_afterstart);

        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //  setSupportActionBar(toolbar);

        CharSequence[] players = getIntent().getCharSequenceArrayExtra("playersnames");

        p01 = getIntent().getBooleanExtra("player1ax", true);

        p02 = getIntent().getBooleanExtra("selectedsingleplayer", true);


        e = getIntent().getBooleanExtra("easy", false);

        m = getIntent().getBooleanExtra("medium", false);

        h = getIntent().getBooleanExtra("hard", false);

        impossible = getIntent().getBooleanExtra("impossible", false);


        if (p01) {
            ax = 1;
            zero = 10;


        }


        pl1 = players[0];

        pl2 = players[1];

        p1 = (TextView) findViewById(R.id.playerone);

        p2 = (TextView) findViewById(R.id.playertwo);

        p1.setText(pl1);
        p2.setText(pl2);

        Toast.makeText(this, "" + pl1 + "\'s turn", Toast.LENGTH_SHORT).show();

    }


    public void a1(View view) {


        if (win == 0 && bp[0][0] == 0) {

            if (flag % 2 == 0)

                t[0][0] = ax;

            else
                t[0][0] = zero;


            printB();

            winc();

            computer();
            flag++;
            bp[0][0]++;
        }
    }


    public void a2(View view) {

        if (win == 0 && bp[0][1] == 0) {

            if (flag % 2 == 0) t[0][1] = ax;

            else t[0][1] = zero;

            printB();

            winc();
            computer();

            bp[0][1]++;

            flag++;
        }
    }

    public void a3(View view) {
        if (win == 0 && bp[0][2] == 0) {
            if (flag % 2 == 0) t[0][2] = ax;

            else t[0][2] = zero;

            printB();

            winc();

            computer();
            bp[0][2]++;
            flag++;
        }
    }

    public void a4(View v) {
        if (win == 0 && bp[1][0] == 0) {

            if (flag % 2 == 0) t[1][0] = ax;

            else t[1][0] = zero;

            printB();

            winc();
            computer();

            ++bp[1][0];
            flag++;
        }
    }

    public void a5(View v) {

        if (win == 0 && bp[1][1] == 0) {

            if (flag % 2 == 0) t[1][1] = ax;

            else t[1][1] = zero;
            printB();

            winc();

            computer();

            ++bp[1][1];
            flag++;
        }
    }

    public void a6(View v) {
        if (win == 0 && bp[1][2] == 0) {

            if (flag % 2 == 0) t[1][2] = ax;


            else t[1][2] = zero;

            printB();

            winc();
            computer();

            ++bp[1][2];
            flag++;
        }
    }

    public void a7(View v) {
        if (win == 0 && bp[2][0] == 0) {

            if (flag % 2 == 0) t[2][0] = ax;

            else t[2][0] = zero;

            printB();

            winc();

            computer();
            ++bp[2][0];
            flag++;
        }
    }

    public void a8(View v) {

        if (win == 0 && bp[2][1] == 0) {

            if (flag % 2 == 0) t[2][1] = ax;
            else t[2][1] = zero;


            printB();

            winc();
            computer();

            ++bp[2][1];

            flag++;
        }
    }

    public void a9(View v) {
        if (win == 0 && bp[2][2] == 0) {

            if (flag % 2 == 0) t[2][2] = ax;

            else t[2][2] = zero;


            printB();

            winc();
            computer();

            ++bp[2][2];

            flag++;

        }

    }


    public void computer() {
        if ((p02) && (win == 0)) {


            if (computerwin()) ;


            else if (win()) ;

            else if (emptyctre()) ;

            else if (empty()) ;

            else empt();


            printB();
            winc();

            flag++;
            return;
        }
    }

    public boolean computerwin() {
        if (!e) {

            for (i = 0; i < 8; i++) {

                if (sum[i] == 2 * zero) {

                    if (i == 0) {

                        for (int x = 0; x < 3; x++)

                            if (t[0][x] == 0)


                                t[0][x] = zero;

                    }


                    if (i == 1) {

                        for (int x = 0; x < 3; x++)

                            if (t[1][x] == 0)

                                t[1][x] = zero;


                    }


                    if (i == 2) {

                        for (int x = 0; x < 3; x++)

                            if (t[2][x] == 0)

                                t[2][x] = zero;

                    }


                    if (i == 3) {

                        for (int x = 0; x < 3; x++)


                            if (t[x][0] == 0)

                                t[x][0] = zero;


                    }


                    if (i == 4) {

                        for (int x = 0; x < 3; x++)

                            if (t[x][1] == 0)

                                t[x][1] = zero;
                    }

                    if (i == 5) {

                        for (int x = 0; x < 3; x++)

                            if (t[x][2] == 0)
                                t[x][2] = zero;

                    }

                    if (i == 6) {


                        for (int y = 0; y < 3; y++)

                            for (int x = 0; x < 3; x++)

                                if (x == y)

                                    if (t[x][y] == 0)

                                        t[x][y] = zero;

                    }
                    if (i == 7) {

                        if (t[0][2] == 0)


                            t[0][2] = zero;


                        else if (t[1][1] == 0)

                            t[1][1] = zero;


                        else t[2][0] = zero;


                    }

                    return true;
                }
            }
        }
        return false;
    }


    public boolean win() {

        if ((!e) || (!m)) {


            for (i = 0; i < 8; i++) {
                if (sum[i] == 2 * ax) {

                    if (i == 0) {

                        for (int x = 0; x < 3; x++)

                            if (t[0][x] == 0) {
                                t[0][x] = zero;

                                bp[0][x]++;

                            }
                    }

                    if (i == 1) {
                        for (int x = 0; x < 3; x++)
                            if (t[1][x] == 0) {

                                t[1][x] = zero;

                                bp[1][x]++;

                            }

                    }

                    if (i == 2) {

                        for (int x = 0; x < 3; x++)

                            if (t[2][x] == 0) {

                                t[2][x] = zero;

                                bp[2][x]++;

                            }


                    }


                    if (i == 3) {

                        for (int x = 0; x < 3; x++)

                            if (t[x][0] == 0) {

                                t[x][0] = zero;

                                bp[x][0]++;

                            }

                    }


                    if (i == 4) {


                        for (int x = 0; x < 3; x++)
                            if (t[x][1] == 0) {

                                t[x][1] = zero;

                                bp[x][1]++;

                            }
                    }


                    if (i == 5) {


                        for (int x = 0; x < 3; x++)

                            if (t[x][2] == 0) {

                                t[x][2] = zero;

                                bp[x][2]++;

                            }

                    }


                    if (i == 6) {

                        for (int y = 0; y < 3; y++)

                            for (int x = 0; x < 3; x++)
                                if (x == y)

                                    if (t[x][y] == 0) {

                                        t[x][y] = zero;

                                        bp[x][y]++;

                                    }


                    }
                    if (i == 7) {

                        if (t[0][2] == 0) {
                            t[0][2] = zero;

                            bp[0][2]++;
                        } else if (t[1][1] == 0) {

                            t[1][1] = zero;

                            bp[1][1]++;

                        } else {

                            t[2][0] = zero;

                            bp[2][0]++;
                        }


                    }
                    return true;

                }
            }

        }
        return false;
    }

    public boolean emptyctre() {
        if (impossible || h) {

            if (t[1][1] == 0) {

                t[1][1] = zero;

                bp[1][1]++;
                return true;
            }
        }


        return false;
    }

    public boolean empty() {


        if (h || impossible)

            if (((t[0][0] + t[2][2]) == 2 * ax) || ((t[0][2] + t[2][0]) == 2 * ax)) {

                for (int k = 0; k < 3; k++)

                    for (int j = 0; j < 3; j++)
                        if ((k + j) % 2 == 1) {

                            if (t[k][j] == 0)

                                t[k][j] = zero;


                            bp[k][j]++;

                            return true;
                        }


            }


        if (impossible)
            if (sum[6] == zero || sum[7] == zero) {
          if (sum[6] == zero) {
     if ((sum[0] + sum[3]) > (sum[2] + sum[5])) {

                        t[0][0] = zero;


                        bp[0][0]++;

                    } else {


                        t[2][2] = zero;
                        bp[2][2]++;

                    }

                    return true;
                }

                if (sum[7] == zero) {

                    if ((sum[0] + sum[5]) > (sum[3] + sum[2])) {

                        t[0][2] = zero;

                        bp[0][2]++;


                    } else {

                        t[2][0] = zero;

                        bp[2][0]++;
                    }
                    return true;
                }

            }


        for (int i = 0; i < 3; i++) {

            if (t[0][i] == ax) {

                if (t[0][0] == 0) {

                    t[0][0] = zero;

                    bp[0][0]++;
                    return true;

                }
                if (t[0][2] == 0) {

                    t[0][2] = zero;

                    bp[0][2]++;
                    return true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {


            if (t[2][i] == ax) {

                if (t[2][0] == 0) {

                    t[2][0] = zero;

                    bp[2][0]++;
                    return true;
                }
                if (t[2][2] == 0) {

                    t[2][2] = zero;

                    bp[2][2]++;
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {

            if (t[i][0] == ax) {

                if (t[0][0] == 0) {

                    t[0][0] = zero;

                    bp[0][0]++;
                    return true;
                }
                if (t[2][0] == 0) {

                    t[2][0] = zero;

                    bp[2][0]++;
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {

            if (t[i][2] == ax) {

                if (t[0][2] == 0) {

                    t[0][2] = zero;

                    bp[0][2]++;

                    return true;
                }
                if (t[2][2] == 0) {

                    t[2][2] = zero;

                    bp[2][2]++;
                    return true;
                }
            }
        }
        return false;

    }

    public void empt() {

        if (flag1 == 0)


            while (true) {

                int x = rand();

                int y = rand();


                if (t[x][y] == 0) {

                    t[x][y] = zero;


                    bp[x][y]++;
                    return;


                }

            }


        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)

                if (t[x][y] == 0) {

                    t[x][y] = zero;

                    bp[x][y]++;

                    return;

                }


    }

    public int rand() {
        return r.nextInt(3);
    }

    public void printB() {
        ImageView a1, b2, c3, d4, e5, f6, g7, h8, i9;

        a1 = (ImageView) findViewById(R.id.tzz);b2 = (ImageView) findViewById(R.id.tzo);

        c3 = (ImageView) findViewById(R.id.tzt);        d4 = (ImageView) findViewById(R.id.toz);
        e5 = (ImageView) findViewById(R.id.too);        f6 = (ImageView) findViewById(R.id.tot);

        g7 = (ImageView) findViewById(R.id.ttz);    h8 = (ImageView) findViewById(R.id.tto);

        i9 = (ImageView) findViewById(R.id.ttt);
        if (t[0][0] == 1) a1.setImageResource(R.drawable.x);      if (t[0][0] == 10) a1.setImageResource(R.drawable.oo);


        if (t[0][1] == 1) b2.setImageResource(R.drawable.x);  if (t[0][1] == 10) b2.setImageResource(R.drawable.oo);


        if (t[0][2] == 1) c3.setImageResource(R.drawable.x);   if (t[0][2] == 10) c3.setImageResource(R.drawable.oo);


        if (t[1][0] == 1) d4.setImageResource(R.drawable.x);
        if (t[1][0] == 10) d4.setImageResource(R.drawable.oo);
        if (t[1][1] == 1) e5.setImageResource(R.drawable.x);
        if (t[1][1] == 10) e5.setImageResource(R.drawable.oo);

        if (t[1][2] == 1) f6.setImageResource(R.drawable.x);
        if (t[1][2] == 10) f6.setImageResource(R.drawable.oo);
        if (t[2][0] == 1) g7.setImageResource(R.drawable.x);
        if (t[2][0] == 10) g7.setImageResource(R.drawable.oo);

        if (t[2][1] == 1) h8.setImageResource(R.drawable.x);
        if (t[2][1] == 10) h8.setImageResource(R.drawable.oo);

        if (t[2][2] == 1) i9.setImageResource(R.drawable.x);
        if (t[2][2] == 10) i9.setImageResource(R.drawable.oo);

        res++;
    }


    public void showDialog(String whoWon, String scoreWon, String whoLose, String scoreLose) {

        final Dialog dialog = new Dialog(levels.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        // TextView playerOneScore = dialog.findViewById(R.id.player_one_score);
        //  TextView playerTwoScore = dialog.findViewById(R.id.player_two_score);
        TextView titleText = dialog.findViewById(R.id.title_text);
        dialog.setCancelable(false);
        dialog.show();

        titleText.setText(whoWon);
        // playerOneScore.setText(whoWon+" Score -> "+scoreWon);
        //  playerTwoScore.setText(whoLose+"Score -> "+scoreLose);

        Button resetButton = dialog.findViewById(R.id.reset_button);
        Button playAgainButton = dialog.findViewById(R.id.play_again_button);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                set();
            }
        });

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                playagain();
            }
        });
    }

    public void winc() {
        flag1++;

        sum[0] = t[0][0] + t[0][1] + t[0][2];
        sum[1] = t[1][0] + t[1][1] + t[1][2];

        sum[2] = t[2][0] + t[2][1] + t[2][2];
        sum[3] = t[0][0] + t[1][0] + t[2][0];

        sum[4] = t[0][1] + t[1][1] + t[2][1];
        sum[5] = t[0][2] + t[1][2] + t[2][2];
        sum[6] = t[0][0] + t[1][1] + t[2][2];
        sum[7] = t[0][2] + t[1][1] + t[2][0];


        currentgamedonechecker++;
        res++;

        for (int i = 0; i < 8; i++)

            if (sum[i] == 3 || sum[i] == 30) {

                win++;

                if ((sum[i] == 3) && (ax == 1)) {

                    score1++;

                    TextView q1 = (TextView) findViewById(R.id.p1score);

                    q1.setText("" + score1);

                    showDialog("" + pl1 + " won!", "" + score1, "" + pl2, "" + score2);


                }

                if ((sum[i] == 3) && (zero == 1)) {
                    score2++;

                    TextView q1 = (TextView) findViewById(R.id.p2score);

                    q1.setText("" + score2);


                    showDialog("" + pl2 + " won!", "" + score2, "" + pl1, "" + score1);

                }


                if ((sum[i] == 30) && (ax == 10)) {

                    score1++;

                    TextView q1 = (TextView) findViewById(R.id.p1score);
                    q1.setText("" + score1);

                    showDialog("" + pl1 + " won!", "" + score1, "" + pl2, "" + score2);


                }

                if ((sum[i] == 30) && (zero == 10)) {

                    score2++;

                    TextView q1 = (TextView) findViewById(R.id.p2score);

                    q1.setText("" + score2);

                    showDialog("" + pl2 + " won!", "" + score2, "" + pl1, "" + score1);


                }

            }

        if ((flag1 == 9) && (win == 0)) {
            showDialog("This is a draw !", "" + score1, "" + pl2, "" + score2);

            drawchecker++;
        }


    }  //end winchecker()

    private void playagain() {
        if ((drawchecker > 0) || (win > 0)) {
            game++;

            TextView qq = (TextView) findViewById(R.id.gamenumber);

            qq.setText("" + game);


            for (int i = 0; i < 8; i++)
                sum[i] = 0;

            drawchecker = 0;


            ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;
            q1 = (ImageView) findViewById(R.id.tzz);     q2 = (ImageView) findViewById(R.id.tzo);

            q3 = (ImageView) findViewById(R.id.tzt);      q4 = (ImageView) findViewById(R.id.toz);
            q5 = (ImageView) findViewById(R.id.too);    q6 = (ImageView) findViewById(R.id.tot);

            q7 = (ImageView) findViewById(R.id.ttz); q8 = (ImageView) findViewById(R.id.tto);

            q9 = (ImageView) findViewById(R.id.ttt);
            q1.setImageDrawable(null);


            q2.setImageDrawable(null);
            q3.setImageDrawable(null);

            q4.setImageDrawable(null);
            q5.setImageDrawable(null);

            q6.setImageDrawable(null);
            q7.setImageDrawable(null);
            q8.setImageDrawable(null);
            q9.setImageDrawable(null);

            for (int i = 0; i < 3; i++)

                for (int j = 0; j < 3; j++)

                    bp[i][j] = 0;

            for (int i = 0; i < 3; i++)

                for (int j = 0; j < 3; j++)

                    t[i][j] = 0;


            if ((game + 1) % 2 == 0)
                Toast.makeText(this, "" + pl1 + "\'s turn", Toast.LENGTH_SHORT).show();


            else
                Toast.makeText(this, "" + pl2 + "\'s turn", Toast.LENGTH_SHORT).show();

            win = 0;
            summ = 0;

            flag1 = 0;

            flag = (game + 1) % 2;


            currentgamedonechecker = 0;


            if (p02 && (game % 2 == 0))

                computer();

        }
    }


    public void set() {


        TextView qq = (TextView) findViewById(R.id.gamenumber);

        qq.setText("" + 1);


        for (int i = 0; i < 3; i++)

            for (int j = 0; j < 3; j++)

                t[i][j] = 0;


        for (int i = 0; i < 3; i++)

            for (int j = 0; j < 3; j++)

                bp[i][j] = 0;

        ImageView q1, q2, q3, q4, q5, q6, q7, q8, q9;

        q1 = (ImageView) findViewById(R.id.tzz);  q2 = (ImageView) findViewById(R.id.tzo);
        q3 = (ImageView) findViewById(R.id.tzt);   q4 = (ImageView) findViewById(R.id.toz);
        q5 = (ImageView) findViewById(R.id.too);     q6 = (ImageView) findViewById(R.id.tot);

        q7 = (ImageView) findViewById(R.id.ttz);  q8 = (ImageView) findViewById(R.id.tto);

        q9 = (ImageView) findViewById(R.id.ttt);
        q1.setImageDrawable(null);
        q2.setImageDrawable(null);
        q3.setImageDrawable(null);


        q4.setImageDrawable(null);
        q5.setImageDrawable(null);
        q6.setImageDrawable(null);
        q7.setImageDrawable(null);
        q8.setImageDrawable(null);
        q9.setImageDrawable(null);


        win = 0;
        drawchecker = 0;
        summ = 0;
        res = 0;
        flag1 = 0;
        score1 = 0;

        score2 = 0;
        game = 1;

        flag = 0;

        currentgamedonechecker = 0;

        TextView qqq = (TextView) findViewById(R.id.p1score);

        qqq.setText("" + score1);

        TextView qqqq = (TextView) findViewById(R.id.p2score);
        qqqq.setText("" + score2);

        Toast.makeText(this, "" + pl1 + "\'s turn", Toast.LENGTH_SHORT).show();


    }


    private void showExitDialog() {
        final Dialog dialog = new Dialog(levels.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout_exit);
        dialog.setCancelable(false);

        dialog.show();

        Button exit = dialog.findViewById(R.id.yes_button);
        final Button dismiss = dialog.findViewById(R.id.no_button);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set();
                finish();
            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
    }
}
