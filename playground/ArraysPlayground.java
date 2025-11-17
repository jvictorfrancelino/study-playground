package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraysPlayground {
    public static void main(String[] args) {
        int[] arrayJaIniciado = {10, 20, 30, 40, 50};
        int[] arrayDeInteiros = new int[10];

        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < arrayDeInteiros.length; i++) {
                System.out.println("Preencha o valor do array de index: " + (i + 1) + "\n");
                arrayDeInteiros[i] = scan.nextInt();
            }
        }

        Integer[] arrayComoObjeto = Arrays.stream(arrayDeInteiros).boxed().toArray(Integer[]::new);

        List<Integer> lista = new ArrayList<>(Arrays.asList(arrayComoObjeto));


        for (int i = 0; i < lista.size(); i++) {
            int valorArray = lista.get(i);
            if (valorArray % 2 == 0) {
                lista.remove(i);
            }
        }

        int[] novoArray = lista.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Array original: " + Arrays.toString(arrayDeInteiros));
        System.out.println("Novo Array: " + Arrays.toString(novoArray));

    }
}
