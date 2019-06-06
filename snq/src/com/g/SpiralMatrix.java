package com.g;

import java.util.*;

public class SpiralMatrix {

    //Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0 ) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length -1;
        int columnBegin = 0;
        int columnEnd =matrix[0].length-1;

        while(rowBegin<=rowEnd && columnBegin<=columnEnd){

            for(int i =columnBegin; i<= columnEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i<= rowEnd; i++){
                res.add(matrix[i][columnEnd]);
            }

            columnEnd--;

            if(rowBegin<=rowEnd){
                for(int i = columnEnd; i>= columnBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            if(columnBegin<=columnEnd){
                for(int i = rowEnd; i>= rowBegin; i--){
                    res.add(matrix[i][columnBegin]);
                }
            }

            columnBegin++;
        }

        return res;
    }
}
