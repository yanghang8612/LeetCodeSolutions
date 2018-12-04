public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(s.length() - i - 1) - 'A' + 1) * Math.pow(26, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
    }
}
