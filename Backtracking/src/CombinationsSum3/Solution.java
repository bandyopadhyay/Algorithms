package CombinationsSum3;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/combination-sum-iii/

216. Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
*/
public class Solution {
	  public List<List<Integer>> combinationSum3(int k, int n) {
	    	
	    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	List<Integer> temp = new ArrayList<Integer>();
	    	
	    	backtrack(result,temp,k,n, 1);
			
	    	return result;
	        
	    }
	    
	    
	    public void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n,int start){
	    	if(temp.size() == k ){
	    		if(sum(temp)==n){
	    		result.add(new ArrayList<Integer>(temp));
	    		}
	    	} else {
	    		
	    		for(int i = start ; i<=9 ; i++){		
	    			temp.add(i);
	    			backtrack(result, temp, k,n, i+1);
	    			temp.remove(temp.size()-1);
	    			
	    		}
	    	}
	    }


		private int sum(List<Integer> temp) {
			int sum = 0 ;
			for(Integer a : temp) {
				sum = sum + a;
			}
			return sum;
		}
		
		
		
		 public static void main (String[] args){
			 Solution s = new Solution();
			 
			 print(s.combinationSum3(2, 5));
		 }


		private static void print(List<List<Integer>> combinationSum3) {
			for(List<Integer> a :combinationSum3 ){
				for(Integer b: a){
					System.out.print(b+ ", ");
				}
				System.out.println();
			}
			
		}
}
