import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return target;
        }

        Arrays.sort(nums);
        int result = 0;
        int sum = 0;
        int diff = -1;
        for (int index=0; index<nums.length-1; index++) {
            int L = index+1;
            int R = nums.length-1;
            while (L < R) {
                sum = nums[index] + nums[L] + nums[R];
                if (diff < 0 || diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    result = sum;
                }
                if (target > sum) {
                    L++;
                }
                if (target < sum) {
                    R--;
                }
                if (diff == 0) {
                    break;
                }
            }
            if (diff == 0) {
                break;
            }
        }
        return result;
    }
}
