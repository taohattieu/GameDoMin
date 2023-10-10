package com.example.gamedomin.util.Grid;

import android.content.Context;
import android.view.View;

import com.example.gamedomin.GameEngine;

public abstract class BaseCell extends View {
    private int value;



    private boolean isBomb;
    private boolean isRevealed;
    private boolean isClicked;
    private boolean isFlagged;

    private int x, y;
    private int i;

    public BaseCell(Context context){
        super(context);
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        isBomb = false;
        isClicked = false;
        isRevealed = false;
        isFlagged = false;
        if (value == -1){
            isBomb = true;
        }
        this.value = value;
    }
    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
       this.isClicked = true;
       this.isRevealed = true;
       invalidate();
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }


    public int getXPos() {
        return x;
    }


    public int getYPos() {
        return y;
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        x = i % GameEngine.WIDTH;
        y = i / GameEngine.HEIGHT;
        invalidate();
    }
}
