package com.example.homie.irineohomer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Touch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        final ImageView imgTouch = (ImageView) findViewById(R.id.imgTouch);
        final EditText txtXY1 = (EditText) findViewById(R.id.txtXY1);
        final EditText txtXY2 = (EditText) findViewById(R.id.txtXY2);
        final EditText txtXYd = (EditText) findViewById(R.id.txtXYd);
        final EditText txtMotion = (EditText) findViewById(R.id.txtMotion);
        final EditText txtQuadrant = (EditText) findViewById(R.id.txtQuadrant);


        imgTouch.setOnTouchListener(new View.OnTouchListener(){
            float iX,iY,fX,fY,dX,dY;
            String mess = "";
            String quad = "";
            public boolean onTouch(View v, MotionEvent motionEvent)
            {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    iX = motionEvent.getX();
                    iY = motionEvent.getY();
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    fX = motionEvent.getX();
                    fY = motionEvent.getY();
                    //Toast.makeText(getBaseContext(), mess, Toast.LENGTH_SHORT).show();

                    txtXY1.setText(iX + " , "+ iY);
                    txtXY2.setText(fX + " , "+ fY);
/*
                    if(iX>=fX && iY>=fY)
                    {
                        txtXYd.setText((iX-fX) + " , "+ (iY-fY));
                    }
                    else if(fX>=iX && iY>=fY)
                    {
                        txtXYd.setText((fX-iX) + " , "+ (iY-fY));
                    }
                    else if(iX>=fX && fY>=iY)
                    {
                        txtXYd.setText((iX-fX) + " , "+ (fY-iY));
                    }
                    else if(fX>=iX && fY>=iY)
                    {
                        txtXYd.setText((fX-iX) + " , "+ (fY-iY));
                    }
*/
                    txtQuadrant.setText("");
                    txtMotion.setText("");
                    txtXYd.setText(Math.abs(iX-fX) + " , "+ Math.abs(iY-fY));
                    if(iX>fX && iY>fY)
                    {
                        mess = "Swiped Left, Swiped Up";
                    }
                    if(iX<fX && iY>fY)
                    {
                        mess = "Swiped Right, Swiped Up";

                    }
                    if(iX>fX && iY<fY)
                    {
                        mess = "Swiped Left, Swiped Down";
                    }
                    if(iX<fX && iY<fY)
                    {
                        mess = "Swiped Right, Swiped Down";
                    }
                    if(fX < imgTouch.getWidth()/2 && fY > imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant III";
                    }
                    if(fX > imgTouch.getWidth()/2 && fY > imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant VI";
                    }
                    if(fX > imgTouch.getWidth()/2 && fY < imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant I";
                    }
                    if(fX < imgTouch.getWidth()/2 && fY < imgTouch.getHeight()/2)
                    {
                        quad = "Quadrant II";
                    }
                    if(Math.abs(iX-fX) == 0 && Math.abs(iY-fY) == 0)
                    {
                        quad = "";
                    }
                    txtMotion.setText(mess);
                    txtQuadrant.setText(quad);

                }

                return true;
            }


        });
    }
}
