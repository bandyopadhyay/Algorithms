package Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://leetcode.com/problems/subsets-ii/
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(result, temp, nums, 0, visited);
        return result;
    }


    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start, boolean[] visited) {

        result.add(new ArrayList<Integer>(temp));

        for (int i = start; i < nums.length; i++) {
             if( visited [i] || ( i>0 && !visited[i-1] &&  nums[i-1] == nums[i])) continue;
            temp.add(nums[i]); // choose
            visited[i] = true;
            backtrack(result, temp, nums, i + 1, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1); //do not choose

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = { 1, 2, 2};
        print(s.subsetsWithDup(arr));
    }

    private static void print(List<List<Integer>> result) {
        for (List<Integer> a : result) {
            for (Integer b : a) {
                System.out.print(b + ", ");
            }
            System.out.println();
        }

    }
}
