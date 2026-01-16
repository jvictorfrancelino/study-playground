package vacation.challenges0601.timeConvertion;

import java.io.*;

public class Solution1 {
    static void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String timeConversion(String s) {
        String hourStr = s.substring(0, 2);
        String rest = s.substring(2, 8);
        String period = s.substring(8);

        int hour = Integer.parseInt(hourStr);

        if (period.equals("AM")){
            if (hour == 12){
                hour = 0;
            }
        }else { //PM
            if (hour != 12) {
                hour += 12;
            }
        }
        return String.format("%02d%s", hour, rest);
    }
}
