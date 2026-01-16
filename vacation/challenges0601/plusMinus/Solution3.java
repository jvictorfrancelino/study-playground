package vacation.challenges0601.plusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution3 {
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
        int pos = 0, neg = 0, zero = 0;
        int n = arr.size();

        for(int x : arr){
            if (x > 0) pos++;
            else if (x < 0) neg++;
            else zero++;
        }

        BigDecimal positiveBigDecimal = new BigDecimal(pos).divide(new BigDecimal(n), 6 , RoundingMode.HALF_UP);
        BigDecimal negativeBigDecimal = new BigDecimal(neg).divide(new BigDecimal(n), 6 , RoundingMode.HALF_UP);
        BigDecimal zeroBigDecimal = new BigDecimal(zero).divide(new BigDecimal(n), 6 , RoundingMode.HALF_UP);

        System.out.println(positiveBigDecimal);
        System.out.println(negativeBigDecimal);
        System.out.println(zeroBigDecimal);
    }
}
