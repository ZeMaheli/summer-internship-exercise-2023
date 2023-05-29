package com.premiumminds.internship.snail;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class SnailPattern implements Callable<int[]> {

    private int size;
    private int[][] matrix;

    /**
     * Main initializer of class
     * 
     * @param s Size
     * @param m Matrix
     */
    public SnailPattern(int s, int[][] m) {
        size = s;
        matrix = m;
    }

    /**
     * Given current row and column indexes returns next ones
     * 
     * @param row       current row index
     * @param column    current column index
     * @param direction current direction
     * @return next row and column indexes of current position
     */
    private int[] getNextpos(int row, int column, String direction) {
        int[] pos = { row, column };
        switch (direction) {
            case "Right":
                pos[0] = row;
                pos[1] = column + 1;
                break;
            case "Down":
                pos[0] = row + 1;
                pos[1] = column;
                break;
            case "Left":
                pos[0] = row;
                pos[1] = column - 1;
                break;
            default:
                pos[0] = row - 1;
                pos[1] = column;
                break;
        }
        return pos;
    }

    /**
     * Given certain direction returns next one
     * 
     * @param currDirection Current direction
     * @return next direction clock wise
     */
    private String getNextDirection(String currDirection) {
        switch (currDirection) {
            case "Right":
                return "Down";
            case "Down":
                return "Left";
            case "Left":
                return "Up";
            default:
                return "Right";
        }
    }

    /**
     * Recursively goes through all positions of matrix clock wise order.
     * 
     * @param size
     * @param direction   initial starting direction which is Right
     * @param rowIndex    starting row index of matrix [0]
     * @param columnIndex starting column index of matrix [0]
     * @param matrix      matrix to iterate
     * @param visited     visited 2d matrix with same size of original matrix.
     *                    Indicates what positions have been visited.
     * @param iteration   number of recursive calls
     * @return all elements of matrix clock wise order.
     */
    private int[] getSnailShellRecursively(int size, String direction, int rowIndex, int columnIndex, int[][] matrix,
            boolean[][] visited, int iteration) {

        String dir = direction;
        int[] elem = { matrix[rowIndex][columnIndex] };
        if (iteration == size * size) {
            return elem;
        }

        visited[rowIndex][columnIndex] = true;
        int[] newPos = getNextpos(rowIndex, columnIndex, dir);
        int newRowIndex = newPos[0];
        int newColumnIndex = newPos[1];

        if (newRowIndex == size || newColumnIndex == size || newColumnIndex == -1 || newRowIndex == -1
                || visited[newRowIndex][newColumnIndex]) {
            dir = getNextDirection(dir);
            newPos = getNextpos(rowIndex, columnIndex, dir);
            newRowIndex = newPos[0];
            newColumnIndex = newPos[1];
        }

        int[] voidRet = getSnailShellRecursively(size, dir, newRowIndex, newColumnIndex, matrix, visited, ++iteration);
        // Add element to front of array
        int[] ret = Arrays.copyOf(voidRet, voidRet.length + 1);
        ret[0] = elem[0];
        System.arraycopy(voidRet, 0, ret, 1, voidRet.length);

        return ret;
    };

    @Override
    public int[] call() throws Exception {
        if (matrix[0].length == 0)
            return new int[0];
        else
            return getSnailShellRecursively(size, "Right", 0, 0, matrix, new boolean[size][size], 1);
    }

}
