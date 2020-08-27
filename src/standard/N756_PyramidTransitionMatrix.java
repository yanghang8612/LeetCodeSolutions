package standard;

import java.util.List;

public class N756_PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        boolean[][] map = new boolean[49][];
        for (String s : allowed) {
            int dig = (s.charAt(0) - 'A') * 7 + s.charAt(1) - 'A';
            if (map[dig] == null) {
                map[dig] = new boolean[7];
            }
            map[dig][s.charAt(2) - 'A'] = true;
        }
        return dfs(bottom, "", map, 0);
    }

    public boolean dfs(String bottom, String next, boolean[][] allowed, int idx) {
        if (bottom.length() == 1) return true;
        if (bottom.length() == next.length() + 1) {
            return dfs(next, "", allowed, 0);
        }
        int dig = (bottom.charAt(idx) - 'A') * 7 + bottom.charAt(idx + 1) - 'A';
        if (allowed[dig] != null) {
            for (int i = 0; i < 7; i++) {
                if (allowed[dig][i] && dfs(bottom, next + (char) (i + 'A'), allowed, idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new N756_PyramidTransitionMatrix().pyramidTransition("BCD", List.of("BCG", "CDE", "GEA", "FFF")));
    }
}
