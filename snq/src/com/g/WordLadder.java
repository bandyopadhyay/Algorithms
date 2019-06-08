package com.g;

import java.util.*;

public class WordLadder {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * <p>
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     * <p>
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     * <p>
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * Output: 5
     * <p>
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     * <p>
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * Output: 0
     * <p>
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList();

        q.add(beginWord);

        int res = 0;


        while (!q.isEmpty()) {

            int size = q.size();

            for (int j = 0; j < size; j++) {

                String s = q.poll();


                if (s.equals(endWord)) return res + 1;

                char[] w = s.toCharArray();

                for (int i = 0; i < w.length; i++) {

                    for (char c = 'a'; c <= 'z'; c++) {
                        w[i] = c;

                        String newWord = new String(w);

                        if (!s.equals(newWord) && words.contains(newWord)) {
                            q.add(newWord);
                            words.remove(newWord);

                        }
                    }
                    w[i] = s.charAt(i);


                }
            }
            res++;

        }

        return 0;

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> result = new LinkedList<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(beginWord));
        wordDict.remove(beginWord);

        while (!queue.isEmpty()) {
            int n = queue.size();
            Set<String> toRemove = new HashSet<>();
            for (int k = 0; k < n; k++) {
                List<String> path = queue.poll();
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char c = chars[i];
                    for (char exch = 'a'; exch <= 'z'; exch++) {
                        if (c != exch) {
                            chars[i] = exch;
                            String nextWord = String.valueOf(chars);
                            if (wordDict.contains(nextWord)) {
                                toRemove.add(nextWord);
                                List<String> newPath = new ArrayList<>(path);
                                newPath.add(nextWord);
                                queue.offer(newPath);

                                if (nextWord.equals(endWord)) {
                                    result.add(newPath);
                                }
                            }
                        }
                    }
                    chars[i] = c;
                }
            }
//            if (!result.isEmpty()) {
//                break;
//            }
            if (!toRemove.isEmpty()) {
                wordDict.removeAll(toRemove);
            }
        }

        return result;
    }
}