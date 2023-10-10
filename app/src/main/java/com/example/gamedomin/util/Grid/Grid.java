package com.example.gamedomin.util.Grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.gamedomin.GameEngine;

public class Grid extends GridView {
    public Grid(Context context) {
        super(context);
        setAdapter(new GridAdapter());
    }

    public Grid(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(new GridAdapter());
    }

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return GameEngine.getInstance().WIDTH * GameEngine.getInstance().HEIGHT;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return GameEngine.getInstance().getCellAt(i);
        }
    }
}
