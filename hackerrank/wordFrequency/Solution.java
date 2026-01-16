package hackerrank.wordFrequency;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Leitura das palavras
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();

            // Incrementa a contagem
            frequencyMap.put(
                    word,
                    frequencyMap.getOrDefault(word, 0) + 1
            );
        }

        int q = Integer.parseInt(scan.nextLine());

        // Consultas
        for (int i = 0; i < q; i++) {
            String query = scan.nextLine();
            System.out.println(frequencyMap.getOrDefault(query, 0));
        }

        scan.close();
    }
}