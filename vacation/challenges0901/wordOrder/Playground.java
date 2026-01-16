package vacation.challenges0901.wordOrder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Playground {
    static void main() {
        Scanner scan = new Scanner(System.in);

        int qtd = Integer.parseInt(scan.nextLine());

        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < qtd; i++){
            String word = scan.nextLine();

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map.size());

        for(int count : map.values()) {
            System.out.println(count + " ");
        }
    }
}
