package hackerrank.uniqueElements;

import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            set.add(line);
            System.out.println(set.size());
        }
    }
}