package com.example.teachme;

import android.util.Log;

public class Letter {
    boolean[] a={false,false,false,false,false,false};
    boolean[] i={false,false,false};


    public String caracter;

    public boolean test(float x,float y)
    {
        switch (caracter)
        {
            case "A":
                return testa(x,y);
            case "I" :
                testi(x,y);



        }
        return true;
    }

    public void testi(float x,float y)
    {
        if ((680<x & x<720)  &(490<y & y<550) )
        {
            Log.i("", "yesss");
            i[0] = true;
        }
        if((680<x & x<720)  &(760<y & y<800))
        {
            Log.i("", "yesss2");
            i[1] = true;
        }
        if((680<x & x<720)  &(950<y & y<1100))
        {
            Log.i("", "yesss3");
            i[2] = true;
        }

    }

    public boolean testa(float x,float y) {
        if ((650 < x & x < 780) & (490 < y & y < 590)) {
            Log.i("", "yesss");
            a[0] = true;
        } else if ((490 < x & x < 600) & (950 < y & y < 1100)) {
            Log.i("", "yesss2");
            a[1] = true;
        } else if ((800 < x & x < 970) & (950 < y & y < 1100)) {
            Log.i("", "yesss3");
            a[2] = true;
        } else if ((500 < x & x < 600) & (700 < y & y < 920)) {
            Log.i("", "yesss4");
            a[3] = true;
        } else if ((800 < x & x < 900) & (700 < y & y < 920)) {
            Log.i("", "yesss5");
            a[4] = true;
        } else if ((680 < x & x < 710) & (700 < y & y < 920)) {
            Log.i("", "yesss6");
            a[5] = true;
        } else if (((10 < x & x < 500) & (490 < y & y < 690)) ||
                   ((10 < x & x < 500) & (590< y & y < 690))||
                    ((10 < x & x < 600) & (690< y & y < 790))
                  )
            return false;

      return true;
    }








}
