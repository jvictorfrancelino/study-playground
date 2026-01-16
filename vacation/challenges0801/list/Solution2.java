package vacation.challenges0801.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] nums = br.readLine().split("\\s+");

        List<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(nums[i]));
        }

        int q = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < q; i++) {
            String op = br.readLine();
            if(op.equals("Insert")) {
                String[] parts = br.readLine().split("\\s+");
                int idx = Integer.parseInt(parts[0]);
                int val = Integer.parseInt(parts[1]);
                list.add(idx, val);
            } else {
                int idx = Integer.parseInt(br.readLine());
                list.remove(idx);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
