package standard;

public class N1376_TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    private int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }

    public static void main(String[] args) {
        System.out.println(new N1376_TimeNeededToInformAllEmployees().numOfMinutes(11, 4, new int[]{5,9,6,10,-1,8,9,1,9,3,4}, new int[]{0,213,0,253,686,170,975,0,261,309,337}));
    }
}
