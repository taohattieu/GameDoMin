package com.example.gamedomin.util;
import  android.content.Context;
public class GameEngine {
    private static GameEngine instance;
    private static final int BOMB_NUMBER = 10;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private  Context context;

    public static GameEngine getInstance(){
        if(instance == null){
            instance = new GameEngine();
        }
        return instance;
    }
    private GameEngine(){}
    public  void createGrid(Context context){
        this.context = context;

        int[][] GenerateGrid = Generator.generate(BOMB_NUMBER,WIDTH,HEIGHT);
    }
}
