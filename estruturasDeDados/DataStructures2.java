package estruturasDeDados;

import java.util.*;

public class DataStructures2 {

    public static void main(String[] args) {

        // --- Array ---
        String[] array = new String[3];
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";
        System.out.println("Array: " + Arrays.toString(array));

        // --- ArrayList ---
        List<String> arrayList = new ArrayList<>();
        arrayList.add("João");
        arrayList.add("Maria");
        System.out.println("ArrayList: " + arrayList);

        // --- LinkedList ---
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Lucas");
        linkedList.add("Larissa");
        System.out.println("LinkedList: " + linkedList);

        // --- HashSet ---
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple"); // duplicata ignorada
        System.out.println("HashSet: " + hashSet);

        // --- LinkedHashSet ---
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("B");
        linkedHashSet.add("A");
        linkedHashSet.add("C");
        System.out.println("LinkedHashSet (ordem inserção): " + linkedHashSet);

        // --- TreeSet ---
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Cachorro");
        treeSet.add("Abelha");
        System.out.println("TreeSet (ordenado): " + treeSet);

        // --- HashMap ---
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("C", 3);
        hashMap.put("B", 2); //sobrescreve
        System.out.println("HashMap: " + hashMap);

        // --- LinkedHashMap ---
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("A", 1);
        linkedHashMap.put("C", 3);
        linkedHashMap.put("B", 2);
        System.out.println("LinkedHashMap (ordem inserção): " + linkedHashMap);

        // --- TreeMap ---
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 3);
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        System.out.println("TreeMap (ordenado por chave): " + treeMap);

        // --- Stack ---
        Stack<String> stack = new Stack<>();
        stack.push("Livro 1");
        stack.push("Livro 2");
        System.out.println("Stack (LIFO): " + stack);
        stack.pop();
        System.out.println("Stack após pop: " + stack);

        // --- PriorityQueue ---
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.add(20);
        pq.add(30);
        System.out.println("PriorityQueue (menor prioridade primeiro): " + pq);
        pq.poll();
        System.out.println("Após poll: " + pq);

        // --- Deque ---
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Início");
        deque.addLast("Fim");
        System.out.println("Deque: " + deque);
        deque.removeFirst();
        System.out.println("Deque após removeFirst: " + deque);

    }
}
