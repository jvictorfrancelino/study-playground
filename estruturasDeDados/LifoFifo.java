package estruturasDeDados;

import java.util.*;

public class LifoFifo {

    public static void main(String[] args) {
        // LIFO (Last in First Out)
        Stack<String> pilha = new Stack<>();
        pilha.push("0 - A");
        pilha.push("1 - B");
        pilha.push("2 - C");

        System.out.println("Imprimindo do começo até o fim a stack: ");
        for (String item : pilha) {
            System.out.println(item); // Ordem: A, B, C (do fundo para o topo)
        }

        // stack
        // 3 - C
        // 2 - B
        // 1 - A


        for(int i = pilha.size() -1; i >= 0; i--) {
            System.out.println(pilha.get(i)); // Ordem: C, B, A
        }
//
//        // Ambas as estruturas implementam Iterable, então é possível
//        // usar Iterator ou ListIterator para mais controle:
//        Iterator<String> it = pilha.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        // No caso do ListIterator em uma Stack, pode-se usar
//        // listIterator(index) para começar do topo:
//        ListIterator<String> it2 = pilha.listIterator(pilha.size());
//        while (it2.hasPrevious()) {
//            System.out.println(it2.previous()); // Iteração LIFO
//        }
//
//        System.out.println(pilha.pop()); // C
//        System.out.println(pilha.pop()); // B
//
//        // Fila - FIFO (First In First Out)
//
//        Queue<String> fila = new LinkedList<>();
//        fila.offer("A");
//        fila.offer("B");
//        fila.offer("C");
//
//        for (String item : fila) {
//            System.out.println(item); // Ordem: A, B, C
//        }
//
//        while (!fila.isEmpty()){
//            System.out.println(fila.poll()); // Remove e imprime
//        }
        Queue<String> fila = new LinkedList<>();
        LinkedList<String> fila2 = new LinkedList<>();
    }
}
