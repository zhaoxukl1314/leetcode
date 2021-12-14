import java.util.TreeSet;

public class test {

    public static void main(String[] args) {
        String a = "abc";
        String b = "cba";
        char[] chars = a.toCharArray();
        char[] chars1 = b.toCharArray();
        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println(chars1.equals(chars));
    }
}
