package hackerrank.findPhone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> phoneBook = new HashMap<>();

        // Leitura do mapa
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            int phone = Integer.parseInt(scan.nextLine());
            phoneBook.put(name, phone);
        }

        // Leitura das consultas até EOF
        while (scan.hasNextLine()) {
            String query = scan.nextLine();

            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        scan.close();
    }
}
