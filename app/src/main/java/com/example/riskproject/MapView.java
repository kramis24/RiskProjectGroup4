package com.example.riskproject;

/**
 * MapView: Illustrates the Risk map
 *
 * @author Dylan Kramis, Phi Nguyen, Charlie Benning
 * @version 9/19/2021 GUI Prototype
 */

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

    // game map, don't want to be loading this constantly
    final private Bitmap mapImage = BitmapFactory.decodeResource(getResources(), R.drawable.risk_board);

    // player colors, more to come
    final private int PLAYER_1_COLOR = 0xFFFF3F3F; // light-ish red
    final private int PLAYER_2_COLOR = 0xFF3F3FFF; // light-ish blue

    /**
     * MapView
     * Constructor for MapView object, based off of SurfaceView class
     *
     * @param context context for MapView object
     * @param attrs attributes for MapView object
     *
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
        textPaint.setTextSize(40);
    }

    /**
     * onDraw
     * Draws the map and all overlaying objects
     * NOTE: Locations of drawn items may look off in current prototype state on emulator!
     *
     * @param canvas canvas being drawn on
     */
    @Override
    protected void onDraw(Canvas canvas) {

        // draws map, this is only hardcoded for this gui prototype
        canvas.drawBitmap(mapImage, -200, -500, mapPaint);

        // draws text boxes indicating troop counts and ownership, only hardcoded for prototype
        drawTextBox(250, 180, 1, PLAYER_1_COLOR, canvas);
        drawTextBox(500, 220, 4, PLAYER_1_COLOR, canvas);
        drawTextBox(250, 350, 1, PLAYER_1_COLOR, canvas);
        drawTextBox(500, 600, 2, PLAYER_1_COLOR, canvas);
        drawTextBox(700, 750, 3, PLAYER_1_COLOR, canvas);
        drawTextBox(1170, 700, 7, PLAYER_2_COLOR, canvas);
        drawTextBox(1400, 620, 3, PLAYER_2_COLOR, canvas);
        drawTextBox(1470, 750, 7, PLAYER_2_COLOR, canvas);
        drawTextBox(1050, 440, 3, PLAYER_2_COLOR, canvas);
        drawTextBox(1050, 150, 3, PLAYER_2_COLOR, canvas);
        drawTextBox(1250, 150, 2, PLAYER_2_COLOR, canvas);
        drawTextBox(1255, 320, 1, PLAYER_2_COLOR, canvas);
        drawTextBox(1500, 150, 1, PLAYER_2_COLOR, canvas);
        drawTextBox(1800, 200, 1, PLAYER_2_COLOR, canvas);
        drawTextBox(1600, 550, 2, PLAYER_2_COLOR, canvas);
    }

    /**
     * drawTextBox
     * Draws a text box with a black background and a colored number showing troop count
     *
     * @param x horizontal position
     * @param y vertical position
     * @param count troop count
     * @param player hex color of player holding territory
     * @param canvas canvas being drawn on
     */
    protected void drawTextBox(int x, int y, int count, int player, Canvas canvas) {

        // draws a black square
        canvas.drawRect(x, y, x + 50, y + 50, boxPaint);

        // adds text in specified player color, this is a rough idea
        textPaint.setColor(player);
        canvas.drawText(Integer.toString(count), x + 5, y + 45, textPaint);
    }
}
