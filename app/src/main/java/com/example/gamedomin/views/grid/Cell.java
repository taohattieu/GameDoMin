package com.example.gamedomin.views.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.example.gamedomin.R;

@SuppressLint("ViewConstructor")
public class Cell extends BaseCell{
    private int position;

    public Cell(Context context, int position) {

        super(context);
        setPosition(position);
    }
    @Override
    protected void onMeasure(int withMeasureSpec, int heightMeasurePec){
        super.onMeasure(withMeasureSpec, withMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Minesweeper", "Cell::onDraw");
        drawButton(canvas);

    }
    private void drawButton(Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0,getWidth(), getHeight());
        drawable.draw(canvas);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
