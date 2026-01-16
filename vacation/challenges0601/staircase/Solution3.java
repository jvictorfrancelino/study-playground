package vacation.challenges0601.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }

    public static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            sb.append(" ".repeat(n - 1));
            sb.append("#".repeat(i));

            System.out.println(sb);
        }
    }
}