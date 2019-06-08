package com.g;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;

    }

    boolean dfs(String s, List<String> wordDict, int start) {

        if(start == s.length()) return true;


        for(int i = start+1; i<s.length(); i++){

            if(wordDict.contains(s.substring(start,i))&& dfs(s,wordDict,i)) return true;
        }

        return false;

    }


}
