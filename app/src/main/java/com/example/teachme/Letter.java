package com.example.teachme;

import android.util.Log;

public class Letter {
    boolean[] a={false,false,false,false,false,false};
    boolean[] b={false,false,false,false,false,false,false,false};
    boolean[] i={false,false,false};
    int wdth;
    int hight;

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
       //Log.i("",  String.valueOf( (xper(x))));
       //1080---->100%
        //x------->%
        Log.i("",  String.valueOf( (xper(618))));
        if ((xper(488) < x & x < xper(618)) & (yper(970) < y & y < yper(590+480))) {

            Log.i("", "yesss");

            a[0] = true;
        } else if (( xper(490-162)< x & x  < xper(600-162)) & (yper(950+480) < y & y < yper(1100+480))) {
            Log.i("", "yesss2");
            a[1] = true;
        } else if ((xper(800-162) < x  & x  < xper(970-162)) & (yper(950+480) < y & y < yper(1100+480))) {
            Log.i("", "yesss3");
            a[2] = true;
        } else if ((xper(500-162) < x  & x  < xper(600-162)) & (yper(700+480) < y & y < yper(920+480))) {
            Log.i("", "yesss4");
            a[3] = true;
        } else if ((xper(800-162) < x  & x  < xper(900-162)) & (yper(700+480) < y & y < yper(920+480))) {
            Log.i("", "yesss5");
            a[4] = true;
        } else if ((xper(680-162) < x  & x  < xper(710-162)) & (yper(700+480) < y & y < yper(920+480))) {
            Log.i("", "yesss6");
            a[5] = true;
        } else if (((xper(10-162) < x  & x  < xper(500-162)) & (yper(490+480) < y & y < yper(690+480))) ||
                   ((10-162 < x & x < 500-162) & (590+480< y & y < 690+480))||
                    ((10-162 < x & x < 600-162) & (690+480< y & y < 790+480))||

                    ((800-162 < x ) & (490+480 < y & y < 690+480))||
                    ((800-162 < x ) & (590+480< y & y < 690+480))||
                    ((800-162 < x ) & (690+480< y & y < 790+480))


        )
            return false;

      return true;
    }
    public float xper(float x)
    {
        float iniper = (x*100)/1080;
        x=(iniper*wdth)/100;
     //float target = (iniper*wdth)/100;

        //45%
        return x;
    }
    public float xper(float x,boolean a )
    {
        float iniper = (x*100)/wdth;
        //float target = (iniper*wdth)/100;

        //45%
        return iniper;
    }
    public float yper(float y)
    {
        float iniper = (y*100)/2177;
        return y=(iniper*hight)/100;
    }
    public float yper(float y,boolean a )
    {
        return (y*100)/hight;
    }
    public boolean testb(float x,float y) {

        Log.i("", "yesss");
        if ((xper(560-162) < x & x < 590-162) & (yper(500+480) < y  & y  < yper(570+480))) {
            Log.i("", "yesss");
             b[0] = true;
        }
        if ((xper(560-162) < x& x < 590-162) & (yper(720+480) < y  & y  < yper(820+480))) {
            Log.i("", "yesss2");
            b[1] = true;
        }
        if ((xper(560-162) < x  & x < xper(590-162)) & (yper(950+480) < y  & y  < yper(1060+480))) {
            Log.i("", "yesss3");
            b[2] = true;
        }

        if ((xper(615-162) < x & x  < xper(715-162)) & (yper(500+480) < y  & y  < yper(570+480))) {
            Log.i("", "yesss4");
            b[3] = true;
        }
        if ((xper(615-162) < x  & x < xper(715-162)) & (yper(720+480) < y & y < yper(820+480))) {
            Log.i("", "yesss5");
            b[4] = true;
        }
        if ((xper(615-162) < x & x < xper(715-162)) & (yper(950+480) < y & y < yper(1060+480))) {
            Log.i("", "yesss6");
            b[5] = true;
        }
        if ((xper(720-162) < x & x  < xper(850-162)) & (yper(614+480) < y & y < yper(690+480))) {
            Log.i("", "yesss7");
            b[6] = true;
        }

        if ((xper(750-162) < x & x < xper(900-162)) & (yper(840+480) < y & y < yper(940+480))) {
            Log.i("", "yesss8");
            b[7] = true;
        }

        return true;
        }







}
