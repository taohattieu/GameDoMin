package com.example.gamedomin;
import  android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.gamedomin.util.Generator;
import com.example.gamedomin.views.grid.Cell;
import com.example.gamedomin.util.PrintGrid;

public class GameEngine {
    private static GameEngine instansce;

    public static final int BOMB_NUMBER = 10;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 16;
    private Context context;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];

    public static GameEngine getInstance(){
        if(instansce == null){
            instansce = new GameEngine();
        }
        return instansce;
    }

    private GameEngine(){  }

    public void createGrid(Context context){
        this.context = context;

        //create the grid and store it
        int[][] GenerateGrid = Generator.generate(BOMB_NUMBER,WIDTH,HEIGHT);
        PrintGrid.print(GenerateGrid,WIDTH,HEIGHT);
        setGrid(context, GenerateGrid);
    }

    private void setGrid( final Context context, final int[][] grid){
        for (int x = 0; x < WIDTH; x++){
            for (int y = 0; y < HEIGHT; y++){
                if (MinesweeperGrid[x][y] == null){
                    MinesweeperGrid[x][y] = new Cell( context, x,y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }
    }

    public View getCellAt(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;
        return MinesweeperGrid[x][y];
    }

    public Cell getCellAt(int x, int y){
        return MinesweeperGrid[x][y];
    }

    public void click(int x, int y){
        if(x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT && !getCellAt(x,y).isClicked()){
            getCellAt(x,y).setClicked();
            if(getCellAt(x,y).getValue() == 0){
                for (int xt = -1; xt <= 1; xt++){
                    for (int yt = -1; yt <= 1; yt++){
                        if (xt != yt){
                            click(x + xt, y + yt);
                        }
                    }
                }
            }
            if (getCellAt(x,y).isBomb()){
                onGameLost();
            }
        }

        checkEnd();
    }

    private boolean checkEnd(){
        int bombNotFound = BOMB_NUMBER;
        int notRevealed = WIDTH * HEIGHT;
        for (int x = 0; x < WIDTH; x++){
            for (int y = 0;y < HEIGHT; y++){
                if (getCellAt(x,y).isRevealed() || getCellAt(x,y).isFlagged()){
                    notRevealed--;
                }
                if (getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb()){
                    bombNotFound--;
                }
            }
        }
        if (bombNotFound == 0 && notRevealed == 0){
            Toast.makeText(context, "Game won", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void flag(int x, int y){
        boolean isFlagged = getCellAt(x,y).isFlagged();
        getCellAt(x,y).setFlagged(!isFlagged);
        getCellAt(x,y).invalidate();
    }

    private void onGameLost(){
        //handle lost game
        Toast.makeText(context, "Game lost", Toast.LENGTH_SHORT).show();

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                getCellAt(x,y).setRevealed();
            }
        }
    }
    public void resetGame(){
        int[][] newGrid = Generator.generate(BOMB_NUMBER, WIDTH, HEIGHT);
        setGrid(context, newGrid);

        // Đặt lại trạng thái của từng ô
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                MinesweeperGrid[x][y].resetCell(); // Tạo phương thức resetCell() trong lớp Cell
            }
        }
    }
}


