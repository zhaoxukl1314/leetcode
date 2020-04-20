public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        if (length == 1 && nums[0] == target) {
            int[] re = {0, 0};
            return re;
        }
        int left = searchLeftIndex(nums,0,length-1,target);
        int right = searchRightIndex(nums, 0, length-1, target);
        int[] res = {left,right};
        return res;

    }

    private static int searchLeftIndex(int[] nums, int left, int right, int target) {
        if (left == right && nums[left] == target) {
            return left;
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                if (middle > 0 && nums[middle - 1] == target) {
                    return searchLeftIndex(nums, left, middle, target);
                }
                return middle;
            }
            if (left == middle) {
                if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
            if (nums[middle] > target) {
                return searchLeftIndex(nums, left, middle, target);
            }
            left = middle;
        }
        return -1;
    }

    private static int searchRightIndex(int[] nums, int left, int right, int target) {
        if (left == right && nums[right] == target) {
            return right;
        }

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                if (middle <nums.length- 1 && nums[middle + 1] == target) {
                    if (right-left == 1 && nums[right] == target) {
                        return right;
                    }
                    return searchRightIndex(nums, middle, right, target);
                }
                return middle;
            }
            if (left == middle) {
                if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
            if (nums[middle] < target) {
                return searchRightIndex(nums, middle, right, target);
            }
            right = middle;
        }
        return -1;
    }
}
