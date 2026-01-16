package vacation.challenges0901.hashSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Pair> set = new HashSet<>();

        int T = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < T; i++){
            String[] parts = br.readLine().split("\\s+");

            String left = parts[0];
            String right = parts[1];

            set.add(new Pair(left, right));
            System.out.println(set.size());
        }
    }

}

class Pair {
    public String name1;
    public String name2;

    Pair(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair pair = (Pair) o;
        if(name1.equals(pair.name1) && name2.equals(pair.name2)) return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = name1.hashCode();
        result = 31 * result + name2.hashCode();
        return result;
    }

}