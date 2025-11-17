package strings.java1darray;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

    public static boolean canWin(int leap, int[] game) {
        int n = game.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while(!stack.isEmpty()){
            int i = stack.pop();

            if(i >= n) return true;
            if(i < 0 || game[i] == 1) continue;

            game[i] = 1;

            stack.push(i + leap);
            stack.push(i + 1);
            stack.push(i - 1);
        }
        return false;
    }
}