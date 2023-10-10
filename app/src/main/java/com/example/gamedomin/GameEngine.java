package com.example.gamedomin;
import  android.content.Context;
import android.view.View;

import com.example.gamedomin.util.Generator;
import com.example.gamedomin.util.Grid.Cell;
import com.example.gamedomin.util.PrintGrid;

public class GameEngine {
    private static GameEngine instance;
    public static final int BOMB_NUMBER = 10;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    private  Context context;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];
    public static GameEngine getInstance(){
        if(instance == null){
            instance = new GameEngine();
        }
        return instance;
    }
    private GameEngine(){}
    public  void createGrid(Context context){
        this.context = context;

        //create the grid and store it
        int[][] GenerateGrid = Generator.generate(BOMB_NUMBER,WIDTH,HEIGHT);
        PrintGrid.print(GenerateGrid,WIDTH,HEIGHT);
    }
    private void setGrid(final Context context, final int[][] Gird){
        for (int x = 0; x < HEIGHT; x++){
            for (int y =0; y < WIDTH; y++){
                if (MinesweeperGrid[x][y] == null){
                    MinesweeperGrid[x][y] = new Cell( context, y * HEIGHT + x);
                }
            }
        }
    }
    public View getCellAt(int i) {
        return null;
    }
}
