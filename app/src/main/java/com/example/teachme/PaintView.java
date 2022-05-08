package com.example.teachme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Arrays;


public class PaintView extends View {
    MyListener ml;
    public LayoutParams params;
    public Path path = new Path();
    public Paint brush = new Paint();
    public Letter letter= new Letter();
    public int pos ;


    public PaintView(Context context) {
        super(context);
        init(null,0);
         }

    public PaintView(Context context, AttributeSet attrs) {
        super(context,attrs);
        init(attrs,0);


    }

    public PaintView(Context context, AttributeSet attrs,int defStyle) {
        super(context,attrs,defStyle);
        init(attrs, defStyle);
    }

    public void init(AttributeSet attrs,int defStyle)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.i("", String.valueOf(height)+" " +String.valueOf(width));
        brush.setAntiAlias(true);
        brush.setColor(Color.MAGENTA);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(60f);
        params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();
        letter.test(pointX, pointY);
        Log.i("", String.valueOf(pointX)+" " +String.valueOf(pointY));
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            path.moveTo(pointX,pointY);
            return true;

            case MotionEvent.ACTION_MOVE:
            path.lineTo(pointX,pointY);
            break;

            case  MotionEvent.ACTION_UP:
                switch (letter.caracter)
                {

                    case "A":
                        if(letter.a[0] & letter.a[1] & letter.a[2] & letter.a[3] & letter.a[4] & letter.a[5])
                        {
                            Arrays.fill(letter.i, false);
                            Toast toast = Toast.makeText(getContext(),"hurray",Toast.LENGTH_SHORT);
                            toast.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            clear();
                            ml.callback(pos);

                        }
                        break;
                    case "I":
                        if(letter.i[0] & letter.i[1] & letter.i[2])
                        {
                            Arrays.fill(letter.i, false);
                            Toast toast = Toast.makeText(getContext(),"hurray",Toast.LENGTH_SHORT);
                            toast.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            clear();
                            ml.callback(pos);

                        }
                        break;
                }
            break;

            default:
                return false;

        }

       postInvalidate();
      return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        ///canvas.drawCircle(x, y, radius, paint);
        canvas.drawPath(path,brush);
    }

    public void clear()
    {
  path.reset();
  invalidate();
    }

    public void setlistener(MyListener listener)
    {
        this.ml= (MyListener)listener;
    }





}
