package vacation.challenges0801.subArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");

        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        int negativeCount = 0;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += a[j];
                if (sum < 0) negativeCount++;
            }
        }
        System.out.println(negativeCount);
    }
}
