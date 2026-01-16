package vacation.challenges0901.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {
    static void main() {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams");
    }


    static boolean isAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : a.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Character c : b.toLowerCase().toCharArray()) {
            if(!map.containsKey(c)) return false;
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) == 0) map.remove(c);
        }
        return map.isEmpty();
    }
 }
