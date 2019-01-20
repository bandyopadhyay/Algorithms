package PermuteUnique.v1;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations/
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 */
public class Solution {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.length];
		backtrack(result, temp, nums, visited);	
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited) {
		if (temp.size() == nums.length) {
			if(!contain(result, temp)){
			result.add(new ArrayList<Integer>(temp));
			}
		} else {
			for (int i = 0; i < nums.length; i++) {	
				if(visited[i]) continue;
				visited[i]=true;
				temp.add(nums[i]); // choose
				backtrack(result, temp, nums, visited);
				temp.remove(temp.size() - 1); // do not choose
				visited[i]=false;
			}
		}
	}

	private boolean contain(List<List<Integer>> result, List<Integer> temp) {
		
		for(List<Integer> list: result){
			if(equal(list,temp)){
				return true;
			}
			
		}
		return false;
	}

	private boolean equal(List<Integer> list, List<Integer> temp) {
	
		for(int i = 0; i<list.size() ; i++){
			if(list.get(i)!=temp.get(i)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int arr[] = { 1, 3, 2};
		print(s.permuteUnique(arr));
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
