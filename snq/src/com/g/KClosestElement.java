package com.g;



import java.util.*;

public class KClosestElement {
    /**
     * 658. Find K Closest Elements
     * Medium
     * Share
     * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
     *
     * Example 1:
     * Input: [1,2,3,4,5], k=4, x=3
     * Output: [1,2,3,4]
     * Example 2:
     * Input: [1,2,3,4,5], k=4, x=-1
     * Output: [1,2,3,4]
     * Note:
     * The value k is positive and will always be smaller than the length of the sorted array.
     * Length of the given array is positive and will not exceed 104
     * Absolute value of elements in the array and x will not exceed 104
     *
     */

    List<Integer> findkclosestelement(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;

        while(right-left+1>k){

            if(Math.abs(arr[left]-x)>Math.abs(arr[right]-x))
                left++;
            else
                right--;
        }

        // binary search
/*
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                left = mid + 1;
            else
                right = mid;
        }

 */



        List<Integer> res = new LinkedList();
        for(int i=left;i<=right;i++)
            res.add(arr[i]);
        return res;
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int lo = 0, hi = arr.length - k;

        Integer[] ans = null;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        //return Arrays.asList(Arrays.copyOfRange(arr,lo, lo + k));
        List<Integer> res = new LinkedList();
        for(int i=lo;i<lo+k;i++)
            res.add(arr[i]);
        return res;
    }


 }