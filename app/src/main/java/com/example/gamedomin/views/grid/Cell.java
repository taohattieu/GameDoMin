package com.example.gamedomin.views.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.gamedomin.GameEngine;
import com.example.gamedomin.R;

@SuppressLint("ViewConstructor")
public class Cell extends BaseCell implements View.OnClickListener, View.OnLongClickListener{
    private int position;

    public Cell(Context context, int position) {

        super(context);
        setPosition(position);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    @Override
    public void onClick(View v) {
        GameEngine.getInstance().click( getXPos(), getYPos());
    }
    @Override
    public boolean onLongClick(View v) {
        GameEngine.getInstance().flag(getXPos(), getYPos());
        return true;
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
        if (isFlagged()){
            drawFlag(canvas);
        }else if (isRevealed() && isBomb() && !isClicked()){
            drawNormalBomb(canvas);
        }else {
            if (isClicked()){
                if (getValue() == -1){
                    drawBombExploded(canvas);
                }else {
                    drawNumber(canvas);
                }
            }else {
                drawButton(canvas);
            }
        }

    }

    private void drawBombExploded(Canvas canvas){
        //Cần sửa ảnh
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_normal);
        drawable.setBounds(0,0,getWidth(), getHeight());
        drawable.draw(canvas);
    }
    private void drawFlag(Canvas canvas){
        //Cần sửa ảnh
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
        drawable.setBounds(0,0,getWidth(), getHeight());
        drawable.draw(canvas);
    }
    private void drawButton(Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0,getWidth(), getHeight());
        drawable.draw(canvas);
    }
    private void drawNormalBomb(Canvas canvas){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_normal);
        drawable.setBounds(0,0,getWidth(), getHeight());
        drawable.draw(canvas);
    }
    private void drawNumber (Canvas canvas){
        Drawable drawable =  null;
        //Cần sửa ảnh
        switch (getValue()){
            case 0:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 1:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 7:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
            case 8:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_android_black_24dp);
                break;
        }

    }


}
