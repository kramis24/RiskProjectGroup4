package com.example.riskproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class MapView extends SurfaceView {

    // member variables
    private Paint mapPaint;
    private Paint boxPaint;
    private Paint textPaint;

    // game map
    final private Bitmap mapImage = BitmapFactory.decodeResource(getResources(), R.drawable.risk_board);

    // player colors
    final private int PLAYER_1_COLOR = 0xFFFF1F1F; // light red
    final private int PLAYER_2_COLOR = 0xFF1F1FFF; // light blue

    /**
     * MapView
     * Constructor for MapView object, based off of SurfaceView class
     *
     * @param context
     * @param attrs
     */
    public MapView(Context context, AttributeSet attrs) {

        // call to SurfaceView constructor and indication that drawing will be done
        super(context, attrs);
        setWillNotDraw(false);

        //setting up paints and colors
        mapPaint = new Paint();
        mapPaint.setColor(Color.BLACK);

        boxPaint = new Paint(mapPaint);

        textPaint = new Paint();
    }

    /**
     * onDraw
     * Draws the map and all overlaying objects
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {

        // draws map, this is only hardcoded for this gui prototype
        canvas.drawBitmap(mapImage, -200, -500, mapPaint);
    }

    protected void drawTextBox(int x, int y, int count, int player, Canvas canvas) {

        // draws a black square
        canvas.drawRect(x, y, x + 50, y + 50, boxPaint);

        // adds text in specified player color
        textPaint.setColor(PLAYER_2_COLOR);
        canvas.drawText(Integer.toString(count), x + 5, y + 5, textPaint);
    }
}
