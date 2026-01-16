package vacation.challenges0601.plusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution1 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Solution1.plusMinus(arr);

        bufferedReader.close();
    }

    public static void plusMinus(List<Integer> arr){
        int n = arr.size();

        int positives = 0;
        int negatives = 0;
        int zeros = 0;

        for (int x : arr){
            if (x > 0) {
                positives++;
            }else if (x < 0) {
                negatives++;
            }else {
                zeros++;
            }
        }

        double pRatio = (double) positives / n;
        double nRatio = (double) negatives / n;
        double zRatio = (double) zeros / n;

        System.out.printf(String.format("%.6f%n", pRatio));
        System.out.printf(String.format("%.6f%n", nRatio));
        System.out.printf(String.format("%.6f%n", zRatio));
    }

}