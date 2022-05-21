package com.example.teachme;

import android.util.Log;

public class Letter {
    boolean[] a={false,false,false,false,false,false};
    boolean[] b={false,false,false,false,false,false,false,false};
    boolean[] i={false,false,false};


    public String caracter;

    public boolean test(float x,float y)
    {
        switch (caracter)
        {
            case "A":
                return testa(x,y);
            case "B":
                return testb(x,y);
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
                    ((10 < x & x < 600) & (690< y & y < 790))||

                    ((800 < x ) & (490 < y & y < 690))||
                    ((800 < x ) & (590< y & y < 690))||
                    ((800 < x ) & (690< y & y < 790))


        )
            return false;

      return true;
    }
    public boolean testb(float x,float y) {
        if ((560 < x & x < 590) & (500 < y & y < 570)) {
            Log.i("", "yesss");
             b[0] = true;
        }
        if ((560 < x & x < 590) & (720 < y & y < 820)) {
            Log.i("", "yesss2");
            b[1] = true;
        }
        if ((560 < x & x < 590) & (950 < y & y < 1060)) {
            Log.i("", "yesss3");
            b[2] = true;
        }

        if ((615 < x & x < 715) & (500 < y & y < 570)) {
            Log.i("", "yesss4");
            b[3] = true;
        }
        if ((615 < x & x < 715) & (720 < y & y < 820)) {
            Log.i("", "yesss5");
            b[4] = true;
        }
        if ((615 < x & x < 715) & (950 < y & y < 1060)) {
            Log.i("", "yesss6");
            b[5] = true;
        }
        if ((720 < x & x < 850) & (614 < y & y < 690)) {
            Log.i("", "yesss7");
            b[6] = true;
        }

        if ((750 < x & x < 900) & (840 < y & y < 940)) {
            Log.i("", "yesss8");
            b[7] = true;
        }

        return true;
        }







}
