package com.g;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;

        if(intervals.length <=1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        Stack<int[]> overlap = new Stack<>();
        overlap.push(intervals[0]);

        for(int i=1; i <intervals.length; i++){

            if(intervals[i][0]<= overlap.peek()[1]){
                int[] item = overlap.pop();
                int[] merged = new int[2];
                  merged[0] = Math.min(intervals[i][0],item[0]);
                merged[1] = Math.max(intervals[i][1],item[1]);
                overlap.push(merged);
            } else {
                overlap.push(intervals[i]);
            }

        }
        return overlap.toArray(new int[overlap.size()][]);

    }

    public int[][] merge2s(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return intervals;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> res = new ArrayList<>();
        int s = 0;
        for(int e = 0; e < n - 1; e++){
            if(ends[e] < starts[e+1]){
                res.add(new int[]{starts[s], ends[e]});
                s = e+1;
            }

            // add last one
            if(e == n - 2){
                res.add(new int[]{starts[s], ends[n - 1]});
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
