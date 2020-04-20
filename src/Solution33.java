public class Solution33 {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return target == nums[0]?0:-1;
        }

        int rotateIndex = findRotateIndex(nums);

        if (target == nums[rotateIndex]) {
            return rotateIndex;
        }

        if (target < nums[0]) {
            return findTarget(nums,rotateIndex,length-1,target);
        } else {
            return findTarget(nums,0,rotateIndex,target);
        }

    }

    private static int findTarget(int[] nums, int start, int end, int target) {

        while (start < end) {
            int middle = (start + end) / 2;
            if (middle == start) {
                if (nums[start] == target) {
                    return start;
                } else if (nums[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return -1;
    }


    private static int findRotateIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return right;
        }
        while (left < right) {
            int middle = (left + right)/2;
            if (middle == left) {
                if (left > right) {
                    return left;
                } else {
                    return right;
                }
            }
            if (nums[middle] > nums[middle+1]) {
                return middle;
            }
            if (middle > 0 && nums[middle] < nums[middle -1]) {
                return middle-1;
            }
            if (nums[middle] > nums[left]) {
                left = middle+1;
            } else if (nums[middle] < nums[right]) {
                right = middle-1;
            }
        }
        return right;
    }
}
