package playground;

import java.util.*;

public class Anything {

    public static void main(String[] args){

        // ============================================================
        // Arrays
        // ============================================================
        String[] array= new String[5];
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";

        int tamanhoArray = array.length;

        for(String a : array){
            System.out.println(a);
        }

        for (int i = 0; i < tamanhoArray; i++){
            if(array[i].contains("B")){
                array[i] = "D";
            }
        }

        for (int i = 0; i < tamanhoArray; i++){
            array[i] = "C";
        }

        // ============================================================
        // ArrayLists
        // ============================================================
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Orange");
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Grape");

        System.out.println("Before sorting: " + arrayList);
        Collections.sort(arrayList); // Sorts in natural ascending order
        System.out.println("After sorting: " + arrayList);

        arrayList.add(2, "Potato");

        String alGet = arrayList.get(1); // get(int) - O(1)
        boolean alContains = arrayList.contains("B"); // contains(Object) - O(n)
        int alIndex = arrayList.indexOf("B"); // indexOf(Object) - O(n)
        int alLastIndex = arrayList.lastIndexOf("B"); // lastIndexOf(Object) - O(n)
        boolean alEmpty = arrayList.isEmpty(); // isEmpty() - O(1)
        int alSize = arrayList.size(); // size() - O(1)

        arrayList.remove("B"); // remove(Object) - O(n) (busca + deslocamento)
        arrayList.remove(0); // remove(int) - O(n) (deslocamento)
        // ============================================================
        // LinkedList
        // ============================================================
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A"); // add(E) no fim - O(1)
        linkedList.add("B"); // O(1)
        linkedList.addFirst("C"); // addFirst(E) - O(1)
        linkedList.addLast("C"); // addLast(E) - O(1)

        String llFirst = linkedList.getFirst(); // getFirst() - O(1)
        String llLast = linkedList.getLast(); // getLast() - O(1)
        String llGet = linkedList.get(1); // get(int) - O(n) (percorre lista)

        boolean llContains = linkedList.contains("A"); // contains(Object) - O(n)
        int llIndex = linkedList.indexOf("A"); // indeOf(Object) - O(n)
        boolean llEmpty = linkedList.isEmpty(); // isEmpty() - O(1)
        int llSize = linkedList.size(); // size() - O(1)

        linkedList.removeFirst(); // removeFirst() - O(1)
        linkedList.removeLast(); // removeLast() - O(1)
        linkedList.remove("B"); // remove(Object) - O(n) (busca + remoção O(1))

        // ============================================================
        // HashSet (Não aceita duplicatas) (Aceita apenas 1 valor nulo)
        // ============================================================
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("A"); // add(E) - O(1) médio, O(n) pior caso
        hashSet.add("B"); // O(1) médio
        hashSet.add("C"); // O(1) médio

        boolean hsContains = hashSet.contains("B"); // contains(Object) - O(1) médio, O(n) pior caso
        boolean hsEmpty = hashSet.isEmpty(); // isEmpty() - O(1)
        int hsSize = hashSet.size(); // size() - O(1)

        hashSet.remove("B"); // remove(Object) - O(1) médio, O(n) pior caso

        // ============================================================
        // TreeSet (Ordenado)
        // ============================================================
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("C"); // add(E) - O(log n)
        treeSet.add("A"); // O(log n)
        treeSet.add("B"); // O(log n)

        boolean tsContains = treeSet.contains("B"); // contains(Object) - O(log n)
        String tsFirst = treeSet.first(); // first() - O(log n) (ou O(1) em algumas impls)
        String tsLast = treeSet.last(); // last() - O(log n)
        boolean tsEmpty = treeSet.isEmpty(); // isEmpty() - O(1)
        int tsSize = treeSet.size(); // size() - O(1)

        treeSet.remove("B"); // remove(Object) - O(log n)

        // ============================================================
        // LinkedHashSet (ordem de inserção)
        // ============================================================
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("A"); // add(E) - O(1) médio
        linkedHashSet.add("B"); // O(1) médio
        linkedHashSet.add("C"); // O(1) médio

        boolean lhsContains = linkedHashSet.contains("C"); // contains(Object) - O(1) médio
        boolean lhsEmpty = linkedHashSet.isEmpty(); // isEmpty() - O(1)
        int lhsSize = linkedHashSet.size(); // size() - O(1)

        linkedHashSet.remove("B"); // remove (Object) - O(1) médio
        // iteração preserva a ordem de inserção - O(n)

        // ============================================================
        // HashMap (Chaves únicas, valores duplicados) (1 chave nula, vários valores nulos)
        // ============================================================
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "A"); // put (K, V) - O(1) médio, O(n) pior caso
        hashMap.put(2, "B"); // O(1) médio
        hashMap.put(3, "C"); // O(1) médio

        String hmGet = hashMap.get(2);  // get(K) - O(1) médio, O(n) pior caso
        boolean hmContainsKey = hashMap.containsKey(3); // containsKey(K) - O(1) médio
        boolean hmContainsValue = hashMap.containsValue("C"); // containsKey(V) - O(n)
        boolean hmEmpty = hashMap.isEmpty(); // isEmpty() - O(1)
        int hmSize = hashMap.size(); // size() - O(1)

        Set<Integer> hmKeys = hashMap.keySet(); 


    }
}
