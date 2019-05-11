package com.practise;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = {4,-3,0,-2,1, -5};
      //  System.out.println(maximumProduct(arr));

        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        topKFrequent(words, 4);

        //int a= Math.pow(2,8);

    }


    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n =nums.length-1;


        if(nums[1] < 0 && nums[n]> 0){

            int negAnswer = nums[0]*nums[1]*nums[n];
            int posAnswer = nums[n]*nums[n-1]*nums[n-2];
            return Math.max(negAnswer,posAnswer);
        }
//        if(nums[n]<0){
//
//        }

        return nums[n]*nums[n-1]*nums[n-2];
    }


    public static List<String> topKFrequent(String[] words, int k) {

        List<String> freq = new LinkedList<>();

        Map<String, Integer> table = new HashMap<>();

        for(String w : words){
            if(table.containsKey(w)){
                table.put(w, table.get(w)+1);
            } else {
                table.put(w,1);
            }
        }

        List<Map.Entry<String, Integer>> enrties = new ArrayList<>(table.entrySet());

        Collections.sort(enrties, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue()-o1.getValue()!= 0) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        for(int i =0; i < k ; i++){
            freq.add( enrties.get(i).getKey());
        }


        return freq;
    }
    public List<List<Integer>> generatePascal(int numRows) {

        List<List<Integer>> pascal = new ArrayList<>(numRows);

        for(int i1 =0 ; i1<numRows; i1++){
            if(i1 == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(1);
                pascal.add(l);
            } else if(i1 ==2){
                List<Integer> l = new ArrayList<>();
                l.add(1);
                l.add(1);
                pascal.add(l);
            } else {
                List<Integer>  last = pascal.get(pascal.size()-1);
                List<Integer> toAdd = new ArrayList<>();

                for(int i= 1; i<last.size(); i++){
                    toAdd.add(last.get(i-1)+ last.get(i));
                }
                pascal.add(toAdd);
            }
        }

        return pascal;
    }

    public int height(TreeNode root) {

        if(root==null){
            return 0;
        } else {
           return  1+ Math.max (height(root.left),height(root.right));
        }

    }

    // 662. Maximum Width of Binary Tree

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int width = 0, start = 0, end = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeLast();
                end = (int)node.val;
                if (i==0) start = end;
                if (node.left != null) {
                    node.left.val = 2 * (int)node.val - 1;
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
                    node.right.val = 2 * (int)node.val;
                    queue.addFirst(node.right);
                }
            }
            width = Math.max(width, end-start+1);
        }
        return width;
    }

}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
 }
