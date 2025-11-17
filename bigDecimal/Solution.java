package bigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            int n = scan.nextInt();
            String[] s = new String[n];
            for(int i = 0; i < n;i++ ){
                s[i] = scan.next();
            }
            // compareTo
            // -1   se o1 <  o2
            // 0    se o1 == o2
            // 1    se o1 >  o2
            Comparator<String> customComparator = new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    BigDecimal a = new BigDecimal(s1);
                    BigDecimal b = new BigDecimal(s2);
                    return b.compareTo(a); // descending order
                }
            };
            Arrays.sort(s, 0, n, customComparator);

            // Forma simplificada
            //ArraysPlayground.sort(s, Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));
            for (int i = 0; i < n;i++ ){
                System.out.println(s[i]);
            }
        }
    }
}
