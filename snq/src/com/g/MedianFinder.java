package com.g;

import java.util.*;

public class MedianFinder {

    List<Integer> list = new ArrayList<>(1000);


    public MedianFinder() {

    }

    public void addNum(int num) {
        int index = Collections.binarySearch(list,num);

        if(index < 0){
            index= -index-1;
        }
        list.add(index,num);
    }

    public double findMedian() {
        int n = list.size();
        int index = (n)/2;
        if((n-1)%2==0){

            return (double)list.get(index);
        } else {

            return  ((double)list.get(index) + (double)list.get(index-1))/2;
        }
    }
}
