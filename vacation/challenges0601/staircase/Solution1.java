package vacation.challenges0601.staircase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        staircase(n);

        bufferedReader.close();
    }

    public static void staircase(int n) {
        char[] palavra = new char[n];
        java.util.Arrays.fill(palavra, ' ');

        for(int i = n - 1; i >= 0; i--){
            palavra[i] = '#';
            System.out.println(palavra);
        }
    }
}
