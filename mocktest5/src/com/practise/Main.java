package com.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public int numJewelsInStones(String J, String S) {


        Map<Character,Integer> m = new HashMap<>();

        for(int i =0 ; i < S.length(); i++){
            m.put(S.charAt(i), m.getOrDefault(S.charAt(i),0)+1);
        }


        int sum =0;

        for(int i =0 ; i < J.length(); i++){
            sum = sum + m.getOrDefault(J.charAt(i),0);
        }

        return sum;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> a = new ArrayList<>();



        ListNode firstNode = head;
        while (firstNode != null){
            a.add(firstNode);
            firstNode = firstNode.next;
        }

        if(a.size()-n == 0) {
            return head.next;
        }

        ListNode prev = a.get(a.size()-n-1);
        ListNode curr = a.get(a.size()-n);
        prev.next=curr.next;

        return head;
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        backtrack(results, new ArrayList<Integer>(), nums, 0);


        return  results;

    }

    private void backtrack(List<List<Integer>> results, ArrayList<Integer> result, int[] nums, int start) {

        if(!results.contains(result))
        results.add(new ArrayList<>(result));

        for(int i=start; i<nums.length; i++){
            result.add(nums[i]);
            backtrack(results,result,nums,i+1);
            result.remove(result.size()-1);
        }

    }
}
