package vacation.challenges0601.plusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution2 {
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

        long positives = arr.stream().filter(x -> x > 0).count();
        long negatives = arr.stream().filter(x -> x < 0).count();
        long zeros = arr.stream().filter(x -> x == 0).count();

        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println(df.format((double) positives / n));
        System.out.println(df.format((double) negatives / n));
        System.out.println(df.format((double) zeros / n));
    }
}
