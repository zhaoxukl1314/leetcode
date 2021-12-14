public class Solution55 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        boolean result = canJump(nums);
        System.out.println(result);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index <= maxJump) {
                int value = nums[index];
                maxJump = Math.max(value + index, maxJump);
                if (maxJump >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
