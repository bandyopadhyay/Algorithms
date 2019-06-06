package com.g;

import java.util.*;

public class BestMeetingPoint {

    //A group of two or more people wants to meet and minimize the total travel distance.
    // You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
    // The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.


    public int minTotalDistance(int[][] grid) {

        int  distance = Integer.MAX_VALUE;
        List<Point> points = new ArrayList<>();



        for(int i =0 ; i<grid.length; i++){
            for(int j= 0; j< grid[0].length; j++){
                if(grid[i][j]==1){
                    points.add(new Point(i,j));
                }
            }
        }


        for(int i =0 ; i<grid.length; i++){
            for(int j= 0; j< grid[0].length; j++){

                distance = Math.min(distance, getCurrentDistance(i,j,points));

            }
        }

        return distance;
    }

    private int getCurrentDistance(int row, int column, List<Point> points) {

        int currentDistance = 0;

        for(Point p : points){

            currentDistance = currentDistance+ Math.abs(p.row-row)+Math.abs(p.column-column);

        }

        return currentDistance;

    }


}

class Point {
    int row;
    int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
