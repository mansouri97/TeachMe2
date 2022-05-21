package com.example.teachme;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    boolean draw = true;
    boolean redraw = false;


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
        boolean b =  letter.test(pointX, pointY);
        if(!b & draw){
            draw=false;
            ml.makeToast();
            return true;
        }

        Log.i("", String.valueOf(b));
        Log.i("", String.valueOf(pointX)+" " +String.valueOf(pointY));
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX,pointY);
            return true;

            case MotionEvent.ACTION_MOVE:
            path.lineTo(pointX,pointY);
            break;

            case  MotionEvent.ACTION_UP:
                if(!draw)
                {  try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    clear(false);
                break;}
                switch (letter.caracter)
                {

                    case "A":
                        if(letter.a[0] & letter.a[1] & letter.a[2] & letter.a[3] & letter.a[4] & letter.a[5])
                        {
                            Arrays.fill(letter.a, false);
                            //ml.makeToast();
                            Toast toast = Toast.makeText(getContext(),"hurray",Toast.LENGTH_SHORT);

                            toast.show();
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            clear(false);
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);

                            builder.setMessage("Passer au caractère suivant?").setPositiveButton("Yes", dialogClickListener)
                                    .setNegativeButton("No", dialogClickListener).show();
                           // ml.callback(pos);

                        }
                        break;
                    case "I":
                        if(letter.i[0] & letter.i[1] & letter.i[2])
                        {
                            Arrays.fill(letter.i, false);
                            Toast toast = Toast.makeText(getContext(),"hurray",Toast.LENGTH_SHORT);
                            View view = toast.getView();
                            view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

                            toast.show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            clear(false);
                            ml.callback(pos);

                        }
                        draw=true;
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

            canvas.drawPath(path,brush);
        
    }

    public void clear(boolean drw)
    {
        path= new Path();
        invalidate();
        draw=true;
    }

    public void setlistener(MyListener listener)
    {
        this.ml= (MyListener)listener;
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    ml.callback(pos);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };





}
