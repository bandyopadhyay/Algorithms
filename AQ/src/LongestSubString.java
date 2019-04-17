import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * 5229
 *
 * 274
 *
 * Favorite
 *
 * Share
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

    public static void main (String[] args){

        LongestSubString l = new LongestSubString();
        System.out.println(l.lengthOfLongestSubstring("abcabcbbxyxzqrsdfsdf"));

    }

    public int lengthOfLongestSubstring(String s) {
        int result = 1;
        for(int i =0; i< s.length(); i++){
            for(int j=i+1; j<= s.length();j++){
             if(allunique(s, i, j)){
                result = Math.max(result, j-i) ;
             }
            }
        }

        return result;

    }

    public boolean allunique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


    public int lengthOfLongestSubstringOptimized(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
