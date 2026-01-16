package vacation.challenges0901.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {
    static void main() throws IOException {
        String palavra1;
        String palavra2;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            palavra1 = br.readLine();
            palavra2 = br.readLine();
        }

        char[] p1Char = palavra1.toLowerCase().toCharArray();
        char[] p2Char = palavra2.toLowerCase().toCharArray();

        Arrays.sort(p1Char);
        Arrays.sort(p2Char);

        System.out.println( (Arrays.equals(p1Char, p2Char) ? "Anagrams" : "Not Anagrams"));
    }
 }
