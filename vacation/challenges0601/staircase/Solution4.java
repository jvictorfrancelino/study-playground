package vacation.challenges0601.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }

    public static void staircase(int n) {
        for (int i = 1; i <= n; i++){
            for (int s = 0; s < n - 1; s++) {
                System.out.print(' ');
            }
            for (int h = 0; h < i; h++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }
}