package vacation.challenges0801.arrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int qtdLinhas = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> data = new ArrayList<>();

        for(int i = 0; i < qtdLinhas;i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int d = Integer.parseInt(parts[0]);

            List<Integer> line = new ArrayList<>(d);
            for(int j = 1; j <= d; j++){
                line.add(Integer.parseInt(parts[j]));
            }

            data.add(line);
        }

        int q = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(parts[0]) - 1;
            int y = Integer.parseInt(parts[1]) - 1;

            if (x < 0 || x >= data.size() || y < 0 || y >= data.get(x).size()) {
                out.append("ERROR!").append('\n');
            } else {
                out.append(data.get(x).get(y)).append('\n');
            }
        }

        System.out.print(out);
    }
}
