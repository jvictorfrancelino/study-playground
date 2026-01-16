package vacation.challenges0601.birtdayCakeCandles;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution2 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int counter = Integer.MIN_VALUE;
        int maxNumber = 0;
        for (int i : candles) {
            if (i == maxNumber) {
                counter++;
            }else if(i > maxNumber){
                maxNumber = i;
                counter = 1;
            }
        }
        return counter;
    }
}
