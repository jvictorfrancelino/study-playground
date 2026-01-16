package hackerrank.groupWordsByLength;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        // TreeMap para manter as chaves (tamanhos) ordenadas
        Map<Integer, List<String>> groups = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            int len = word.length();

            // Cria a lista se ainda não existir
            groups.computeIfAbsent(len, k -> new ArrayList<>())
                    .add(word);
        }

        // Impressão
        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(String.join(" ", entry.getValue()));
        }

        scan.close();
    }
}