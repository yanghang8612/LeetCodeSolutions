package standard;

public class N125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(!Character.isLetterOrDigit(s.charAt(i)) && i < j) i += 1;
            while(!Character.isLetterOrDigit(s.charAt(j)) && i < j) j -= 1;
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
