package standard;

public class N922_SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int n = A.length, even = 0, odd = n - 1;
        while (even < n && odd >= 0) {
            while (even < n && A[even] % 2 == 0) even += 2;
            while (odd >= 0 && A[odd] % 2 == 1) odd -= 2;
            if (odd < 0 || even >= n) break;
            int tmp = A[odd];
            A[odd] = A[even];
            A[even] = tmp;
            even += 2; odd -= 2;
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
