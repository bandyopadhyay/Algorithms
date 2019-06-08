package com.g;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int cnt = 0;
        for(int i =0; i< grid.length; i++)
            for(int j=0; j< grid[i].length; j++){
                if( grid[i][j]==1 && !visited [i][j]){

                 dfs(grid,i,j,visited);
                    cnt++;
             }
            }


        return cnt;


    }

    private void dfs(char[][] grid, int row, int column, boolean[][] visited) {

        if(row < 0 || row > grid.length -1 || column<0 || column > grid[row].length-1 || visited[row][column]) return;
        visited[row][column] = true;
        if(grid[row][column]==1){
            dfs(grid,row+1,column,visited);
            dfs(grid,row-1,column,visited);
            dfs(grid,row,column-1,visited);
            dfs(grid,row,column+1,visited);
        }

    }
}
