package com.app.lenovo.thebirthdayproject;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private float x1,x2,y1,y2;
    static final int MIN_DISTANCE = 150;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String g=df.format(new Date());
    String f=g.substring(0,2);
    int called=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Calendar c = Calendar.getInstance();
        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
        if(f.equals("29"))
        {
            setContentView(R.layout.activity_main);
            final TextView mSwitcher = (TextView) findViewById(R.id.textview1);
            mSwitcher.setText("Old text. This is totally experimental, I tell ya!");
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException e)
            {
            }
            final Animation in = new AlphaAnimation(0.0f, 1.0f);
            in.setDuration(5000);
            final Animation out = new AlphaAnimation(1.0f, 0.0f);
            out.setDuration(5000);
            mSwitcher.startAnimation(out);
            out.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    mSwitcher.setText("New Text. I hope this works bruh!");
                    mSwitcher.startAnimation(in);

                }
                @Override
                public void onAnimationRepeat(Animation am)
                {
                }
                @Override
                public void onAnimationStart(Animation am)
                {
                }
            });
            in.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    mSwitcher.setText("Old text. This is totally experimental, I tell ya!");
                    mSwitcher.startAnimation(out);

                }
                @Override
                public void onAnimationRepeat(Animation am)
                {
                }
                @Override
                public void onAnimationStart(Animation am)
                {
                }
            });
        }
        else if(f.equals("30"))
        {
            setContentView(R.layout.activity_day2);
        }
        else if(f.equals("1"))
        {
            setContentView(R.layout.activity_day3);
        }
        else if(f.equals("2"))
        {
            setContentView(R.layout.activity_day4);
        }
        else if(f.equals("3"))
        {
            setContentView(R.layout.activity_day5);
        }
        else if(f.equals("4"))
        {
            setContentView(R.layout.activity_day6);
        }
        else if(f.equals("5"))
        {
            setContentView(R.layout.activity_day7);
        }
        /*final AnimationSet as = new AnimationSet(true);
        as.addAnimation(out);
        in.setStartOffset(3000);
        as.addAnimation(in);*/
        /*Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                mSwitcher.startAnimation(out);
            }
        });*/
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2=event.getY();
                float deltaX = x2 - x1;
                float deltaY=y2-y1;
                if (deltaX > MIN_DISTANCE)
                {
                    Toast.makeText(this, "Left2Right swipe", Toast.LENGTH_SHORT).show ();
                }
                else if(deltaX<-MIN_DISTANCE)
                {
                    Toast.makeText(this, "Right2Left swipe", Toast.LENGTH_SHORT).show ();
                    int x=Integer.parseInt(f),i;
                    int arr[]={29,30,1,2,3,4,5};
                    for(i=0;i<7;i++)
                        if(x==arr[i])
                            break;
                    //called%=i;
                    if(i-called>0)
                        i=i-called;
                    else
                    {
                        called=called-i;
                        i=i-called+6;
                    }
                    called++;
                    switch (i) {
                        case 0:
                            setContentView(R.layout.activity_day3);
                            break;
                        case 1:
                            setContentView(R.layout.activity_day2);
                            break;
                        case 2:
                            setContentView(R.layout.activity_day3);
                            break;
                        case 3:
                            setContentView(R.layout.activity_day4);
                            break;
                        case 4:
                            setContentView(R.layout.activity_day5);
                            break;
                        case 5:
                            setContentView(R.layout.activity_day6);
                            break;
                        case 6:
                            setContentView(R.layout.activity_day7);
                            break;
                    }
                }
                else if(deltaY<MIN_DISTANCE)
                {
                    Toast.makeText(this, "Swipe up", Toast.LENGTH_SHORT).show ();
                }
                else
                {
                    Toast.makeText(this, "Swipe down", Toast.LENGTH_SHORT).show ();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

}
