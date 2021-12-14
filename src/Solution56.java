import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(nums);
        System.out.println(result);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int index = 0; index < intervals.length; index++) {
            int left = intervals[index][0], right = intervals[index][1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < left) {
                result.add(intervals[index]);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
