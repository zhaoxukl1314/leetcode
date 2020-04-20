public class Solution31 {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        boolean flag = true;

        int i=0,j=0;
        int index= length-1;
        while (index > 0) {
            if (nums[index] > nums[index-1]) {
                i = index-1;
                flag = false;
                break;
            }
            index--;
        }
        if (index==0 && flag) {
            reverse(nums,0);
        } else {
            index = length-1;
            while (index > 0) {
                if (nums[index] > nums[i]) {
                    j=index;
                    swap(nums,i,j);
                    break;
                }
                index--;
            }
            reverse(nums,i+1);
        }
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
