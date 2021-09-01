import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        lists.forEach(System.out::println);
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> track = new LinkedList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, target, 0, candidates);
        return res;
    }

    public static void backtrack(int curSum, int target, int start, int[] candidates) {
        if (curSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length && curSum + candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curSum += candidates[i];
            track.add(candidates[i]);
            backtrack(curSum, target, i + 1, candidates);
            curSum -= candidates[i];
            track.removeLast();
        }
    }
}
