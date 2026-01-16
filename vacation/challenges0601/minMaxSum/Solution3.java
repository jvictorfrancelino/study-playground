package vacation.challenges0601.minMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class Solution3 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        arr.sort(null);

        long sum = 0;
        for (int x : arr) {
            sum += x;
        }

        long minSum = sum - arr.get(arr.size() - 1);
        long maxSum = sum - arr.get(0);

        System.out.println(minSum + " " + maxSum);
    }
}
