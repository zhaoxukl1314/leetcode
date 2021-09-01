import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution45 {

    public static void main(String[] args) {
//        int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
//        int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{2,3,0,1,4};
        int result = jump(nums);
        System.out.println(result);
    }

    static int max;
    static Integer jumps = 0;

    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        List<Integer> collect = IntStream.of(nums).boxed().collect(Collectors.toList());
        max = Collections.max(collect);
        jumps++;
        getResult(nums, nums.length -1, nums.length - max - 1);
        return jumps;
    }

    private static void getResult(int[] nums, int length, int start) {
        if (start < 0) {
            start = 0;
        }
        for (int index = start; index < length + 1; index++) {
            if (nums[index] >= length - index) {
                if (index == 0) {
                    break;
                }
                jumps++;
                getResult(nums, index, index - max);
                break;
            }
        }
    }

//    static int LENGTH;
//
//    public static int jump(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        List<Integer> resultList = new ArrayList<>();
//        LENGTH = nums.length - 1;
//        getResult(nums, resultList, LENGTH, 0, 0);
//        return resultList.get(0);
//    }
//
//    private static void getResult(int[] nums, List<Integer> resultList, int length, int step, int jumps) {
//        if (length == 0) {
//            if (resultList.size() == 0) {
//                resultList.add(jumps);
//                return;
//            }
//            if (resultList.size() > 0 && resultList.get(0) > jumps) {
//                resultList.clear();
//                resultList.add(jumps);
//            }
//            return;
//        }
//        int maxStep = nums[step];
//        for (int index = 1; index <= maxStep && step + index <= LENGTH; index++) {
//            getResult(nums, resultList, length - index, step + index, ++jumps);
//            --jumps;
//        }
//    }
}
