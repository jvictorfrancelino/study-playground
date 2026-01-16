package vacation.challenges0601.minMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class Solution4 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        long sum = arr.stream().mapToLong(Integer::longValue).sum();
        int min = arr.stream().min(Integer::compareTo).orElse(0);
        int max = arr.stream().max(Integer::compareTo).orElse(0);

        System.out.println((sum - max) + " " + (sum - min));
    }
}
