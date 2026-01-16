package vacation.challenges0901.phoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++ ) {
            String name = sc.nextLine();
            String phone = sc.nextLine();
            map.put(name, phone);
        }

        while (sc.hasNextLine()) {
            String query = sc.nextLine();
            if (map.containsKey(query)) {
                System.out.println(query + "=" + map.get(query));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
