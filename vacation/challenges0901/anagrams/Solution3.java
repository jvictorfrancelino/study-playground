package vacation.challenges0901.anagrams;

import java.util.Scanner;

public class Solution3 {
    static void main() {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;

        int[] freq = new int[26];

        for(char c : a.toLowerCase().toCharArray()) {
            freq[c - 'a']++;
        }

        for(char c : b.toLowerCase().toCharArray()) {
            freq[c - 'a']--;
        }

        for(int x : freq) {
            if (x != 0) return false;
        }

        return true;
    }
}
