package com.drewmx.drewsfirstgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Color;

/**
 * Created by Andrew.Maddox on 9/26/2017.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
   private MainThread Thread;
    private RectPlayer player;
    private Point playerPoint;

    public GamePanel(Context context){

        super(context);
        getHolder().addCallback(this);

        Thread = new MainThread(getHolder(), this);
        player = new RectPlayer(new Rect(100, 100, 200, 200), Color.rgb(255, 0, 0));
        playerPoint = new Point(150, 150);

        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder,int format, int width, int height ){


    }
    @Override
    public void surfaceCreated(SurfaceHolder holder){
        Thread = new MainThread(getHolder(), this);
        Thread.setRunning(true);
        Thread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        if (retry = true){
            try {
                Thread.setRunning(false);
                Thread.join();

            } catch (Exception e){e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                playerPoint.set((int)event.getX(), (int)event.getY());
        }

        return true;
        //return super.onTouchEvent(event);
    }

    public void update(){
        player.update(playerPoint);

    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        player.draw(canvas);
    }
}
