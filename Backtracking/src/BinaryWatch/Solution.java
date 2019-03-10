package BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-watch/
401. Binary Watch

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/
public class Solution {

	private final int[] TIME_BIT_VALUES = {1,2,4,8, 1,2,4,8,16,32};
	public List<String> readBinaryWatch(int num) {

		List<String> result = new ArrayList<>();

		if(num > 10) {
		 return result;
		}
		  // to hold combination of the time, each index represents a bit indicating hour minute
          int[] timeSet = new int[10];
		backtrack(timeSet, num, 0, result,0);
		return result;

	}

	private void backtrack( int[] timeset, int num, int k, List<String> result, int start) {
		if(k==num){
			String time = getTime(timeset);
			if(time!=null){
				if(!result.contains(time))
				result.add(time);
			}
		} else {
			for(int i = start; i < timeset.length; i++) {
				if (timeset[i] == 0) {
					timeset[i] = 1;
					backtrack(timeset, num, k + 1, result, start + 1);
					timeset[i] = 0;
				}
			}
		}

	}

	private String getTime(int[] bits) {
		int hour = 0;
		for (int i = 0; i < 4; i++) {
			hour += bits[i] * TIME_BIT_VALUES[i];
		}
		if (hour > 11) {
			return null;
		}
		int min = 0;
		for (int i = 4; i <10; i++) {
			min += bits[i] *  TIME_BIT_VALUES[i];
		}
		if (min > 59) {
			return null;
		}
		return concat(min, hour);
	}

	private String concat(int min, int hour) {
		StringBuilder timeBuilder = new StringBuilder();
		timeBuilder.append(hour);
		timeBuilder.append(":");
		if (min < 10) {
			timeBuilder.append(0);
		}

		timeBuilder.append(min);
		return timeBuilder.toString();
	}


	public static void main(String[] args) {
		Solution s = new Solution();

		print(s.readBinaryWatch(2));
	}

	private static void print(List<String> readBinaryWatch) {

		for (String s : readBinaryWatch) {
			System.out.println(s);
		}
	}


}
