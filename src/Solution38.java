public class Solution38 {

    public static void main(String[] args) {
        countAndSay(5);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        int position = 0;
        int current = 1;
        StringBuilder result = new StringBuilder();

        String s = countAndSay(n-1);

        for (current = 1; current < s.length(); current++) {
            if (s.charAt(position) != s.charAt(current)) {
                int count = current - position;
                result.append(count).append(s.charAt(position));
                position = current;
            }
        }

        if (position != current) {
            int count = current - position;
            result.append(count).append(s.charAt(position));
        }
        return result.toString();
    }
}
