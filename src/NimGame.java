import java.util.Random;

public class NimGame {

    public boolean canWinNim(int n) {
        return canWinNim(n, true);
    }

    private boolean canWinNim(int n, boolean isMyTurn) {
        if (n > 0 && n < 4) return isMyTurn;
        return canWinNim(n - 1, !isMyTurn)
                && canWinNim(n - 2, !isMyTurn)
                && canWinNim(n - 3, !isMyTurn);
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(200));
    }
}
