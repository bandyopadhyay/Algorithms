package com.g;

import java.util.*;

public class SlidingWindowMedian {

    public static void main(String[] args) {


        // write your code here
    }


    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] answer = new double[n-k+1];

        boolean even = k%2 == 0;

        for(int i  = 0 ; i < n-k ; i++){

            int[] window = new int[k];
            for(int j= i; j<i+k; j++){

                window[j-i]=nums[j];
            }

            Arrays.sort(window);

            if(even) {
                answer[i] = ( window[k/2 ] + window[k/2 +1])/2;
            } else {
                answer[i] = window[k/2 ];
            }


        }

        return answer;
    }



    public double[] anotherWay(int[] nums, int k) {

        int n = nums.length;
        double[] answer = new double[n-k+1];

        List<Integer> win = new ArrayList<>();

        boolean even = k%2 == 0;

        for(int i = 0; i< k; i++){
            win.add(nums[i]);
        }

        Collections.sort(win);

        answer[0] = getResult(win,k,even);

        for(int i  = 1 ; i < n-k ; i++){
            int indexToRemove = Collections.binarySearch(win, nums[i-1]);
            win.remove(indexToRemove);
            int indexToAdd = Collections.binarySearch(win, nums[i+k-1]);
            if(indexToAdd<0) indexToAdd = -indexToAdd -1; // not found
            win.add(indexToAdd, nums[i+k-1]);
            answer[i] = getResult(win,k,even);
        }

        return answer;
    }

    double getResult(List<Integer> win ,  int k, boolean even){
        if(even) {
           return ((double)win.get(k/2-1)+(double)win.get(k/2))/2;
        } else {
            return win.get(k/2);
        }
    }
}




