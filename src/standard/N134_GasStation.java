package standard;

public class N134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i]) continue;

        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
