package WildcardMatching;

/**
 https://leetcode.com/problems/wildcard-matching/
 44. Wildcard Matching
 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 */
public class Solution1 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return true;
        if (p.replace("*", "").length() > s.length()) //pass TLE
            return false;

        int row = s.length();
        int col = p.length();

        boolean[][] match = new boolean[row+1][col+1];


        match[0][0] = true;

        for (int i = 1; i <= col && p.charAt(i-1) == '*'; i++){
            match[0][i] = true;
        }

        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                if (p.charAt(j-1) == '*'){
                    match[i][j] = match[i-1][j-1] || match[i-1][j] || match[i][j-1];
                }
                else if (p.charAt(j-1) == '?'){
                    match[i][j] = match[i-1][j-1];
                }
                else{
                    match[i][j] = match[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }

        return match[row][col];
    }


    public static void main(String[] args){
        Solution1 s = new Solution1();
        System.out.println(s.isMatch("abefcdgiescdfimde","ab*cd?i*de"));
    }
}
