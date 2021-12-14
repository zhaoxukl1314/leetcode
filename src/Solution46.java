import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        int length = nums.length;
        List<Integer> collect = IntStream.of(nums).boxed().collect(Collectors.toList());
        getResult(collect, result, length, 0);
        return result;
    }

    private static void getResult(List<Integer> nums, List<List<Integer>> result, int length, int first) {
        if (length == first) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int index = first; index < nums.size(); index++) {
            Collections.swap(nums, first, index);
            getResult(nums, result, length, first + 1);
            Collections.swap(nums, first, index);
        }
    }
}
