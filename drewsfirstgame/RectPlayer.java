package com.drewmx.drewsfirstgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Point;

/**
 * Created by Andrew.Maddox on 9/28/2017.
 */

public class RectPlayer implements GameObject {

    private Rect rectangle;
    private int color;
    public Rect getRectangle(){
        return rectangle;
    }

    public RectPlayer(Rect rectangle, int color)
    {
        this.rectangle = rectangle;
        this.color = color;
    }


    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle,paint );
    }

    @Override
    public void update()
    {


    }

    public void update(Point point)
    {
        //L,T,R,B
        rectangle.set(point.x - rectangle.width()/2, point.y - rectangle.height()/2,point.x + rectangle.width()/2, point.y + rectangle.height()/2 );
    }
}
