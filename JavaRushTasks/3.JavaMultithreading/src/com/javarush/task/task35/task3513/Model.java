package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by AMalakhov on 12.07.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;
    protected int score = 0;
    protected int maxTile = 2;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();
    private boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();
        for (int i = 0;i < gameTiles.length;i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTileList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTileList;
    }

    private void addTile() {
        List list = getEmptyTiles();
        if (list != null&&list.size() != 0) {
            int randomNumber = (int) (list.size() * Math.random());
            getEmptyTiles().get(randomNumber).value = (Math.random() < 0.9 ? 2 : 4);}
    }

    protected void resetGameTiles() {
        gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
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
        saveState(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
    }

    public void right() {
        saveState(gameTiles);
        rotateCW(gameTiles);
        rotateCW(gameTiles);
        left();
        rotateCW(gameTiles);
        rotateCW(gameTiles);
    }

    public void left() {
        if (isSaveNeeded){
            saveState(gameTiles);
        }
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

    private Tile[][] saveState(Tile[][] tiles) {
        Tile[][] savedTiles = new Tile[gameTiles.length][gameTiles[0].length];
        for (int i=0;i<savedTiles.length;i++){
            for (int j = 0; j < savedTiles[0].length; j++){
                savedTiles[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(savedTiles);
        previousScores.push(score);
        isSaveNeeded = false;
        return savedTiles;
    }

    public void rollback(){
        if (!previousStates.isEmpty()&&!previousScores.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0: right();
                break;
            case 1: left();
                break;
            case 2: up();
                break;
            case 3: down();
                break;
        }
    }

    public boolean hasBoardChanged () {
        int sum1=0;
        int sum2=0;
        if (!previousStates.isEmpty()) {
            Tile[][] previouseGameTiles = (Tile[][]) previousStates.pop();
            for (int i = 0; i<gameTiles.length; i++){
                for (int j = 0; j < gameTiles[0].length; j++){
                    sum1 += previouseGameTiles[i][j].value;
                    sum2 += gameTiles[i][j].value;
                }
            }}

        return sum1!=sum2;

    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()){
            moveEfficiency=new MoveEfficiency(getEmptyTiles().size(),score,move);
        }
        else {
            moveEfficiency=new MoveEfficiency(-1,0,move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                left();
            }
        }));
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                right();
            }
        }));
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                up();
            }
        }));
        priorityQueue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                down();
            }
        }));

        priorityQueue.poll().getMove().move();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public int getScore() {
        return score;
    }
}