package vacation.challenges0601.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }

    public static void staircase(int n) {
        for (int i = 1; i <= n; i++){
            char[] line = new char[n];
            java.util.Arrays.fill(line, ' ');
            java.util.Arrays.fill(line, n - 1, n, '#');
            System.out.println(line);
        }
    }
}