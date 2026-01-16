package vacation.challenges0701.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4 {
    static void main() throws IOException {
        String palavra1;
        String palavra2;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            palavra1 = bufferedReader.readLine();
            palavra2 = bufferedReader.readLine();
        }

        char[] ca = palavra1.toLowerCase().toCharArray();
        char[] cb = palavra2.toLowerCase().toCharArray();

        Arrays.sort(ca);
        Arrays.sort(cb);

        System.out.println( (Arrays.equals(ca, cb) ? "Anagrams" : "Not Anagrams"));
    }
}
