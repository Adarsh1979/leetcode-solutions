import java.util.*;

public class lc_697 {

    public static int[] findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> num_counts = new HashMap<>();
        HashMap<Integer, Integer> first_seen = new HashMap<>();

        int degree = 0;
        int min_length = Integer.MAX_VALUE;

        int start = 0, end = 0; // track best subarray

        for (int i = 0; i < nums.length; i++) {
            first_seen.putIfAbsent(nums[i], i);

            num_counts.put(nums[i], num_counts.getOrDefault(nums[i], 0) + 1);
            int count = num_counts.get(nums[i]);

            if (count > degree) {
                degree = count;

                start = first_seen.get(nums[i]);
                end = i;

                min_length = end - start + 1;
            } 
            else if (count == degree) {
                int currStart = first_seen.get(nums[i]);
                int currLength = i - currStart + 1;

                if (currLength < min_length) {
                    min_length = currLength;
                    start = currStart;
                    end = i;
                }
            }
        }

        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,3,2,1,5};
        int[] ans = lc_697.findShortestSubArray(nums);
        System.out.println(Arrays.toString(ans));
    }
}