package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Integer> MASK = Arrays.asList(
            255 << 0 & 0xFF, 255 << 1 & 0xFF, 255 << 2 & 0xFF, 255 << 3 & 0xFF,
            255 << 4 & 0xFF, 255 << 5 & 0xFF, 255 << 6 & 0xFF, 255 << 7 & 0xFF,
            255 << 8 & 0xFF
    );

    public int checkNetSegment(String mask, String ip1, String ip2) {
        List<Integer> maskDigits = getDigitsOfIP(mask);
        List<Integer> ip1Digits = getDigitsOfIP(ip1);
        List<Integer> ip2Digits = getDigitsOfIP(ip2);
        if (null == maskDigits || null == ip1Digits || null == ip2Digits
                || !validMask(maskDigits)) {
            return 1;
        }
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb1.append(maskDigits.get(i) & ip1Digits.get(i)).append(".");
            sb2.append(maskDigits.get(i) & ip2Digits.get(i)).append(".");
        }
        return sb1.toString().equals(sb2.toString()) ? 0 : 2;
    }

    private List<Integer> getDigitsOfIP(String ip) {
        String[] digits = ip.split("\\.", -1);
        if (digits.length != 4) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        try {
            for (String s : digits) {
                int digit = Integer.parseInt(s);
                if (digit < 0 || digit > 255) {
                    return null;
                }
                res.add(digit);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    private boolean validMask(List<Integer> masks) {
        for (int i = 0; i < 3; i++) {
            if (!MASK.contains(masks.get(i))) {
                return false;
            }
            if (masks.get(i) != 255 && masks.get(i + 1) != 0) {
                return false;
            }
        }
        return MASK.contains(masks.get(3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            if (strs.length == 3) {
                System.out.println(main.checkNetSegment(strs[0], strs[1], strs[2]));
            }
        }
    }
}
