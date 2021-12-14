import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution49 {

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strings);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(string);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

}
