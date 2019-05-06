import java.util.*;

public class t3sum {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> triplets = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //don't consider duplicates
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a + b + c;

                if (sum == 0) {
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(a);
                    triplet.add(b);
                    triplet.add(c);
                    triplets.add(triplet);
                    start++;
                    //don't consider duplicates
                    while (start < end && nums[start] == nums[start -1]) start++;
                } else if (sum > 0) end--;
                else start++;
            }
        }
        return triplets;
    }





}
