import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution39 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> combine = new ArrayList<>();
       getResult(candidates, target, result, combine, 0);
       return result;
    }

    private static void getResult(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }
        getResult(candidates, target, result, combine, index + 1);
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            getResult(candidates, target - candidates[index], result, combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
