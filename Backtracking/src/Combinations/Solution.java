package Combinations;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/combinations/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
	
	// key: for each element there are two options. Choose and not choose. Use backtracking to continue
	// with the every single element of the temporary list.
     public List<List<Integer>> combine(int n, int k) {
    	 List<List<Integer>> result = new ArrayList<List<Integer>>();
    	 List<Integer> temp = new ArrayList<Integer>();
    	 backtrack(result,temp,1,n,k);
    	 return result;
    }
     
     private void backtrack(List<List<Integer>> result, List<Integer> temp, int start, int n,int k) {
    	 if(temp.size() ==k){  
    		 result.add(new ArrayList<Integer>(temp));
    	 } else {
    		 for(int i = start ; i<=n; i++){
    			 if(temp.contains(i)) continue;
    			 temp.add(i); //choose
    			 backtrack(result,temp,i+1,n,k);
    			 temp.remove(temp.size()-1); //not choose
    		 }
    	 }
     }
     
     public static void main(String[] args){
    	 Solution s = new Solution();
    	 print(s.combine(4, 2));
     }

     private static void print(List<List<Integer>> result) {
 		for(List<Integer> a :result ){			
 			for(Integer b: a){
 				System.out.print(b+ ", ");
 			}
 			System.out.println();
 		}
 		
 	}
}
