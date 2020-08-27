package standard;

public class N041_FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
                swap(A, i, A[i] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int test() {
        int a = 0;
        assert a == 0;
        try {
            System.out.println("Outer");
            try {
                System.out.println("Inner");
            } finally {
                return 0;
            }
        } finally {
            return 1;
        }
    }


    public static void main(String[] args) {
        System.out.println(new N041_FirstMissingPositive().test());
    }
}
