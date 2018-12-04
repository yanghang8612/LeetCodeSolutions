public class ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] c = s.replaceAll("\\s+", " ").replaceAll("(^\\s)|(\\s$)", "").toCharArray();
        for (int i = 0, start = 0; i < c.length; i++) {
            if (i == 0 || c[i - 1] == ' ' && c[i] != ' ') start = i;
            if (i == c.length - 1 || c[i] != ' ' && c[i + 1] == ' ') reverseWord(c, start, i);
        }
        reverseWord(c, 0, c.length - 1);
        return String.valueOf(c);
    }

    private void reverseWord(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("  the  sky is blue    "));
        //System.out.println(" the sky is blue ".replaceAll("(^\\s)|(\\s$)", ""));
    }
}
