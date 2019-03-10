package SlidingWindow;

import java.util.*;

// https://www.youtube.com/watch?v=J6o_Wz-UGvc
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> q = new LinkedList<>();


        for (int i = 0; i < nums.length; i++) {

            // Remove elements out of window
            if (!q.isEmpty() && q.peek() == i - k) {
                q.removeFirst();
            }

            // dq is in descending order (invariant)
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            // push the current element to the deque
            q.addLast(i);

            // add to the result after the length of the sliding window
            if (i >= k - 1) {
                result[i - k + 1] = nums[q.peekFirst()];
            }

        }

        return result;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        print(s.maxSlidingWindow(arr, 3));
    }

    private static void print(int[] maxSlidingWindow) {

        for (int i = 0; i < maxSlidingWindow.length; i++) {
            System.out.print(maxSlidingWindow[i] + ", ");
        }
    }


}
