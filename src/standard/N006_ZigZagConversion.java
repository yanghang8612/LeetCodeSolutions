package standard;

public class N006_ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++)
                sb[idx].append(s.charAt(i++));
            for (int idx = numRows - 2; idx > 0 && i < len; idx--)
                sb[idx].append(s.charAt(i++));
        }
        for (int j = 1; j < numRows; j++)
            sb[0].append(sb[j]);
        return sb[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(new N006_ZigZagConversion().convert("PAYPALISHIRING", 4));
    }
}
