package vacation.challenges0601.minMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class Solution1 {
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

        int minNumber = arr.get(0);
        int maxNumber = arr.get(arr.size() - 1);
        long minSum = 0;
        long maxSum = 0;

        for (Integer integer : arr) {
            minSum += integer;
        }

        for (Integer integer : arr) {
            maxSum += integer;
        }

        minSum -= maxNumber;
        maxSum -= minNumber;
        System.out.println(minSum + " " + maxSum);
    }
}
