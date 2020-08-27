package standard;

public class N419_BattleshipsInABoard {

    public int countBattleships(char[][] b) {
        int cnt = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == 'X' && (i == 0 || b[i - 1][j] == '.')
                        && (j == 0 || b[i][j - 1] == '.')) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        
    }
}
