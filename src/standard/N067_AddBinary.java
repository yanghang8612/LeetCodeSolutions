package standard;

public class N067_AddBinary {

    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length(), n = Math.max(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        char[] ra = new StringBuilder(a).reverse().toString().toCharArray();
        char[] rb = new StringBuilder(b).reverse().toString().toCharArray();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int res = carry + (i < aLen ? ra[i] - '0' : 0)
                    + (i < bLen ? rb[i] - '0' : 0);
            sb.append((char)(res % 2 + '0'));
            carry = res / 2;
        }
        return (carry == 0 ? "" : "1") + sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new N067_AddBinary().addBinary("11", "1"));
    }
}
