package hackerrank.javaArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int qtdLinhas = scan.nextInt();

        ArrayList<ArrayList<Integer>> linhas = new ArrayList<>();

        for(int i  = 0; i < qtdLinhas;i++) {
            int d = scan.nextInt();
            ArrayList<Integer> linha = new ArrayList<>();

            for (int j = 0; j < d; j++){
                linha.add(scan.nextInt());
            }

            linhas.add(linha);
        }

        int target = scan.nextInt();

        for(int i = 0; i < target; i++){
            int targetLinha = scan.nextInt();
            int targetColuna = scan.nextInt();

            try{
                System.out.println(linhas.get(targetLinha - 1)
                        .get(targetColuna -1));
            } catch (IndexOutOfBoundsException ex){
                System.out.println("ERROR!");
            }

        }

    }
}
