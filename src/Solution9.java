import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution9 {

    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        if (input.length() == 1) {
            return true;
        }
        char[] chars = input.toCharArray();
        List<String> list = new ArrayList<>();
        List<String> reverseList = new ArrayList<>();
        for (char aChar : chars) {
            list.add(String.valueOf(aChar));
            reverseList.add(String.valueOf(aChar));
        }
        Collections.reverse(reverseList);
        int size = list.size();
        for (int index = 0; index<size; index++) {
            if (!list.get(index).equalsIgnoreCase(reverseList.get(index))) {
                return false;
            }
        }
        return true;
    }
}
