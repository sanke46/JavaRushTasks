package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
        resetGameTiles();
    }

    public List<Tile> getEmptyTiles() {
        List<Tile> currentEmptyTile = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    currentEmptyTile.add(gameTiles[i][j]);
                }
            }
        }
        return currentEmptyTile;
    }

    private void addTile() {
        List emptyTiles = getEmptyTiles();
        Tile tileRandom = (Tile) emptyTiles.get((int) (Math.random() * emptyTiles.size()));
        tileRandom.value = (Math.random() < 0.9 ? 2 : 4);
    }

    private boolean compareTiles(Tile[] tiles) {
        boolean isChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = 0; j < tiles.length - 1; j++) {
                if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                   tiles[j] = tiles[j+1];
                   tiles[j+1] = new Tile();
                   isChanged = true;
                }
            }
        }

        return isChanged;
    }

    private void mergeTiles(Tile[] tiles) {

    }

    protected void resetGameTiles() {
        gameTiles =  new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH ; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }
}
