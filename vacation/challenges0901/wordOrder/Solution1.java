package vacation.challenges0901.wordOrder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map.size());

        for(int count : map.values()) {
            System.out.println(count + " ");
        }
    }
}
