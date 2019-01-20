package CombineDifferentSets;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example: 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<>();
		String[] letter = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		if(!digits.isEmpty()){
		backtrack(result, new StringBuilder(), digits.toCharArray(), 0, letter);
		}
		return result;

	}

	private void backtrack(List<String> result, StringBuilder temp, char[] digits, int index, String[] letter) {
		if (index == digits.length) {
			result.add(new String(temp));
		} else {
			char[] set = letter[digits[index] - '0'].toCharArray();
			for (int i = 0; i < set.length; i++) {
				temp.append(set[i]);
				backtrack(result, temp, digits, index + 1, letter);
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		print(s.letterCombinations("452"));
	}

	private static void print(List<String> letterCombinations) {

		for (String s : letterCombinations) {
			System.out.println(s);
		}
	}

}
