package packages.util;

import java.util.*;

public class Playground {
    static void main() {
        // List - coleção ORDENADA, aceita duplicatas
        // interface base: List<E>

        // Mais usada
        // Acesso rápido por índice
        List<String> arrayList = new ArrayList<>();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A"); // duplicado permitido

        System.out.println(arrayList); // [A, B, A]
        System.out.println(arrayList.get(1)); // B
        System.out.println(arrayList.size()); // 3

        // Mantém ordem de inserção
        // Acesso O(1)
        // Inserção no meio é custosa

        // ==========================================

        // Boa para muitas inserções/remoções
        // Implementa List e Deque

        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.remove(0);

        System.out.println(list); // [20]

        // Acesso O(n)
        // Inserção/remoção O(1) nos extremos

        // ==========================================
        // ==========================================

        // Set - não aceita duplicatas

        //HashSet
        // Não mantém ordem
        // Muito rápido

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("Java"); // ignorado

        System.out.println(hashSet.size()); // 2

        // Não garante ordem
        // não aceita duplicatas
        // Usa hashCode() + equals()

        // ==========================================

        // LinkedHashSet
        // Mantém ordem de inserção

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("B");
        linkedHashSet.add("A");
        linkedHashSet.add("C");

        System.out.println(linkedHashSet); // [B, A, C]

        // ==========================================

        // TreeSet
        // Mantém ordem
        // Não aceita null
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);

        // Ordenação automática
        // custo O(log n)

        // ==========================================
        // ==========================================

        //Map - chave -> valor (Estrutura mais cobrada)

        // HashMap
        // Permite 1 chave null

    }
}
