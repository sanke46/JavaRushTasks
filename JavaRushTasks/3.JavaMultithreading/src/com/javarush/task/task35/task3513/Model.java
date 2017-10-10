package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMalakhov on 12.07.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score=0;
    protected int maxTile=2;

    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();
        for (int i = 0;i < gameTiles.length;i++){
            for (int j = 0; j < gameTiles.length; j++){
                if (gameTiles[i][j].value==0){
                    emptyTileList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTileList;

    }
    private void addTile() {
        List list = getEmptyTiles();
        if (list != null&&list.size()!=0){
            int randomNumber = (int) (list.size() * Math.random());
            getEmptyTiles().get(randomNumber).value = (Math.random() < 0.9 ? 2 : 4);}
    }
    protected void resetGameTiles() {
        gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j< gameTiles.length; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged=false;
        for (int i = 0; i < tiles.length-1; i++){
            if (tiles[i].value == 0&&tiles[i+1].value!=0){
                int temp;
                temp = tiles[i].value;
                tiles[i].value = tiles[i+1].value;
                tiles[i+1].value = temp;
                isChanged = true;
                i =- 1;
            }
        }
        return isChanged;
    }
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged=false;
        for (int i = 0; i < tiles.length-1; i++){
            if (tiles[i].value == tiles[i+1].value&&tiles[i].value!=0){
                tiles[i].value = tiles[i].value + tiles[i+1].value;
                tiles[i+1].value = 0;
                if (tiles[i].value > maxTile){
                    maxTile=tiles[i].value;
                }
                score+=tiles[i].value;
                isChanged=true;
            }
        }
        compressTiles(tiles);
        return isChanged;
    }

    public void rotateCW(Tile[][] matrix) {
        int length = matrix.length;
        Tile tile = null;
        for (int i = 0; i < length ; i++) {
            for (int j = 0; j < length - 1 - i ; j++) {
                tile = matrix[i][j];
                matrix[i][j] = matrix[length-1-j][length-1-i];
                matrix[length-1-j][length-1-i] = tile;
            }
        }

        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < length; j++) {
                tile = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-1-i][j] = tile;
            }
        }
    }

    public boolean canMove(){
        if (!getEmptyTiles().isEmpty()){
            return true;
        }
        for(int i = 0; i < gameTiles.length; i++) {
            for(int j = 1; j < gameTiles.length; j++) {
                if(gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for(int j = 0; j < gameTiles.length; j++) {
            for(int i = 1; i < gameTiles.length; i++) {
                if(gameTiles[i][j].value == gameTiles[i-1][j].value)
                    return true;
            }
        }
        return false;
    }

    public void up() {
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
    }

    public void down() {
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
    }

    public void right() {
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
        rotateCW(gameTiles);
    }


    public void left() {
        boolean isCompressed = false;
        boolean isMerged = false;
        for (int i = 0;i < gameTiles.length; i++){
            isCompressed = compressTiles(gameTiles[i]);
            isMerged = mergeTiles(gameTiles[i]);
        }
        if (isCompressed || isMerged){
            addTile();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public int getScore() {
        return score;
    }
}