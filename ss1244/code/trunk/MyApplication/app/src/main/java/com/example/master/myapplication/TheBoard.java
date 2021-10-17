package com.example.master.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shaheer saleem on 3/23/2021.
 */

public class TheBoard extends View {

    public static final int LINE_THICK = 5;

    public static final int ELT_MARGIN = 20;

    public static final int ELT_STROKE_WIDTH = 50;

    public int w, h, m, H1;
    //  public int   board;
    public Paint color, color1, color2;

    public intelligence intelligence;
    public MainActivity activity;

    public TheBoard(Context context) {
        super(context);
    }





    public TheBoard(Context context, AttributeSet attrs) {



        super(context, attrs);
        color = new Paint();

        color1 = new Paint(Paint.ANTI_ALIAS_FLAG);

        color1.setColor(Color.BLACK);
        color1.setStyle(Paint.Style.STROKE);

        color1.setStrokeWidth(ELT_STROKE_WIDTH);
        color2 = new Paint(color1);

        color2.setColor(Color.BLACK);
    }

    public void setIntelligence(intelligence g) {

        intelligence = g;
    }

    public void setMainActivity(MainActivity a) {

        activity = a;
    }







    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);

        drawBoard(canvas);
    }

    @Override
    protected void onMeasure(int wmeasure, int heightm) {
        h = View.MeasureSpec.getSize(heightm);

        w = View.MeasureSpec.getSize(wmeasure);

        m = (w - LINE_THICK) / 3;

        H1 = (h - LINE_THICK) / 3;

        setMeasuredDimension(w, h);
    }






    private void drawBoard(Canvas canvas) {

        for (int i = 0; i < 3; i++) {


            for (int j = 0; j < 3; j++) {
                draw1(canvas, intelligence.get1(i, j), i, j);
            }
        }
    }

    private void drawGrid(Canvas canvas) {
        for (int i = 0; i < 2; i++) {


            float l = m * (i + 1);


            float r = l + LINE_THICK;



            float t = 0;


            float b = h;

            canvas.drawRect(l, t, r, b, color);



            float l2 = 0;



            float r2 = w;

            float t2 = H1 * (i + 1);

            float b2 = t2 + LINE_THICK;

            canvas.drawRect(l2, t2, r2, b2, color);
        }
    }

    private void draw1(Canvas canvas, char c, int x, int y) {
        if (c == 'O') {
            float cx = (m * x) + m / 2;

            float cy = (H1 * y) + H1 / 2;

            canvas.drawCircle(cx, cy, Math.min(m, H1) / 2 - ELT_MARGIN * 2, color1);

        } else if (c == 'X') {
            float b = (m * x) + ELT_MARGIN;

            float b1 = (H1 * y) + ELT_MARGIN;




            float c1 = b + m - ELT_MARGIN * 2;

            float c2 = b1 + H1 - ELT_MARGIN;

            canvas.drawLine(b, b1, c1, c2, color2);

            float b01 = (m * (x + 1)) - ELT_MARGIN;

            float b02 = (H1 * y) + ELT_MARGIN;

            float c01 = b01 - m + ELT_MARGIN * 2;
            float c02 = b02 + H1 - ELT_MARGIN;

            canvas.drawLine(b01, b02, c01, c02, color2);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!intelligence.over() && event.getAction() == MotionEvent.ACTION_DOWN) {

            int x = (int) (event.getX() / m);

            int y = (int) (event.getY() / H1);

            char win = intelligence.play(x, y);
            invalidate();

            if (win != ' ') {
                activity.gameEnded(win);
            } else {

                win = intelligence.AI();
                invalidate();

                if (win != ' ') {
                    activity.gameEnded(win);
                }
            }
        }
        return super.onTouchEvent(event);
    }
}