public class StringToInteger {
    public static int myAtoi(String str) {
        if (null == str || 0 == str.length()) {
            return 0;
        }
        int i = 0, base = 0, sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }

            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            base = base * 10 + str.charAt(i++) - '0';
        }
        return base * sign;
    }


}
