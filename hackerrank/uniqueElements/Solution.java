package hackerrank.uniqueElements;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int linhas = Integer.valueOf(scan.next());

        Set<String> set = new HashSet<>();
        for( int i = 0; i < linhas; i++){
            String first = scan.next();
            String second = scan.next();

            String pair = first + " " + second;
            set.add(pair);

            System.out.println(set.size());

        }
        scan.close();
    }
}