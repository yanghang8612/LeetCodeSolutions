import java.util.*;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        List vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while (i < j) {
            while (i < j && !vowels.contains(c[i])) i += 1;
            while (i < j && !vowels.contains(c[j])) j -= 1;
            if (i < j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i += 1;
                j -= 1;
            }
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("a"));
    }
}
