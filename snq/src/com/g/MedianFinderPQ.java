package com.g;

import java.util.PriorityQueue;

public class MedianFinderPQ {
    PriorityQueue<Integer> asce;
    PriorityQueue<Integer> desc;

    /** initialize your data structure here. */
    public MedianFinderPQ() {
        asce = new PriorityQueue<>((n1, n2) -> n1 - n2);
        desc = new PriorityQueue<>((n1, n2) -> n2 - n1);
    }

    public void addNum(int num) {
        asce.offer(num);
        desc.offer(asce.poll());
        if (desc.size() > asce.size()) {
            asce.offer(desc.poll());
        }
    }

    public double findMedian() {
        if ((asce.size() + desc.size()) % 2 == 1) {
            return asce.peek();
        } else {
            return (asce.peek() + desc.peek()) / 2.0;
        }
    }
}
