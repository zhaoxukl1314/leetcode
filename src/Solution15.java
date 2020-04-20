import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            int L = index+1;
            int R = nums.length - 1;
            while (L < R) {
                if (index > 0 && nums[index] == nums[index-1]) {
                    break;
                }
                int sum = nums[index] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[index], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L+1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R -1]) {
                        R--;
                    }
                    L++;
                    R--;
                }
                if (sum > 0) {
                    R--;
                }
                if (sum < 0) {
                    L++;
                }
            }
        }
        return result;
    }
}
