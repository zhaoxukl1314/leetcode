public class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        if (nums[0] > target) {
            return 0;
        }

        if (nums[length-1] < target) {
            return length;
        }

        for (int index = 0; index <= nums.length-1; index++) {
            if (nums[index] >= target) {
                return index;
            }
        }
        return length;

    }
}
