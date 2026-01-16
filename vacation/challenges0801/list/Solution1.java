package vacation.challenges0801.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtdLinhas = scan.nextInt();

        List<Integer> listaNumeros = new ArrayList<>();

        for (int i = 0; i < qtdLinhas; i++) {
            listaNumeros.add(scan.nextInt());
        }

        int qtdOperacoes = scan.nextInt();

        for (int i = 0; i < qtdOperacoes; i++) {
            String operacao = scan.next();
            if(operacao.equals("Insert")) {
                int targetPosition = scan.nextInt();
                int targetValue = scan.nextInt();
                listaNumeros.add(targetPosition, targetValue);
            } else if (operacao.equals("Delete")) {
                int targetDelete = scan.nextInt();
                listaNumeros.remove(targetDelete);
            }
        }

        for (int num : listaNumeros) {
            System.out.println(num + " ");
        }
    }
}
