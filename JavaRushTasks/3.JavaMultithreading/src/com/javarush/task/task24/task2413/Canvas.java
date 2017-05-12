package com.javarush.task.task24.task2413;

/**
 * Created by ilafedoseev on 11.05.17.
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height){
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];

    }

    public void setPoint(double x, double y, char c){
        if (!(x < 0 || y < 0 || y > matrix.length || x > matrix[0].length)){
            int newX = Math.toIntExact(Math.round(x));
            int newY = Math.toIntExact(Math.round(y));
            matrix[newY][newX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] != 0){
                    setPoint(x+j, y+i, c);
                }
            }
        }
    }

    public void clear(){
        matrix = new char[height+2][width+2];
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    //getter
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    //setter
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
