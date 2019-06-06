package com.g;

public class WordMatch {

    boolean wordExists(char[][] board, String word) {

        int row = board.length;
        int column = board[0].length;

        boolean[][] visited = new boolean[row][column];


        for(int i = 0; i<row; i++) {
            for(int j = 0; j<board[i].length ; j++){
                if(board[i][j]== word.charAt(0)){
                    if(dfs(board, word, i,j,0, visited)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int column, int index, boolean[][] visited) {

        if(index==word.length()) return true;

        if(row<0 || row>=board.length ||
            column<0 || column>=board[row].length ||
                word.charAt(index)==board[row][column] ||
                visited[row][column])

            return false;

        visited[row][column] = true;

        index++;

        boolean exists = dfs(board, word, row,column+1,index, visited) ||
                dfs(board, word, row,column-1,index, visited) ||
                dfs(board, word, row-1,column,index, visited) ||
                dfs(board, word, row+1,column,index, visited);


        visited[row][column] = false;

        return exists;
    }


}
