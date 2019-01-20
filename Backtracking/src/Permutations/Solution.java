package Permutations;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations/
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		backtrack(result, temp, nums);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
		if (temp.size() == nums.length) {
			result.add(new ArrayList<Integer>(temp));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (temp.contains(nums[i]))
					continue;
				temp.add(nums[i]); // choose
				backtrack(result, temp, nums);
				temp.remove(temp.size() - 1); //do not choose
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int arr[] = { 1, 2, 3, 4 };
		print(s.permute(arr));
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
