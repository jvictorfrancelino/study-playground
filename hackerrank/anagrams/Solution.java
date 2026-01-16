package hackerrank.anagrams;

import java.util.*;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();

        // Normaliza para minúsculas
        a = a.toLowerCase();
        b = b.toLowerCase();

        // Conta frequência da primeira string
        for (char c : a.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Remove frequência usando a segunda string
        for (char c : b.toCharArray()) {
            if (!freq.containsKey(c)) {
                return false;
            }

            freq.put(c, freq.get(c) - 1);

            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }

        // Se o mapa estiver vazio, são anagramas
        return freq.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();

        System.out.println(isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
        scan.close();
    }
}
