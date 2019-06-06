package com.g;

import java.util.ArrayList;
import java.util.List;

//986. Interval List Intersections
public class IntervalIntersection {
    /**
     * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
     * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
     */

    public int[][] intervalIntersection(int[][] A, int[][] B) {

            List<int[]> list = new ArrayList<>();
            for (int i = 0, j = 0; i < A.length && j < B.length;){
                if (A[i][1] < B[j][1]){
                    if (B[j][0] <= A[i][1]) {
                        list.add(new int[]{Math.max(A[i][0], B[j][0]), A[i][1]});
                    }
                    i++;
                } else {
                    if (A[i][0] <= B[j][1]) {
                        list.add(new int[]{Math.max(B[j][0], A[i][0]), B[j][1]});
                    }
                    j++;
                }
            }

          return list.toArray(new int[list.size()][]);
    }
}


