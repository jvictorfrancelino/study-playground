package playground.streamss;

import strings.tagContentExtractor.Main;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPlayground {
    //helper:
    static boolean isPrime(int n){
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int d = 3; d * d <= n; d += 2)
            if (n % d == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int soma = nums.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println(soma);

        List<String> nomes = List.of("ana","bia","jo","carla","ada");
        List<String> res = nomes.stream()
                .filter(s -> s.length() >= 3)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println(res);

        List<Integer> xs = List.of(3,1,4,1,5,9,2,6,5);
        IntSummaryStatistics stats = xs.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println(stats);
        // count=7, sum=30, min=1, average=4.285..., max=9

        List<String> nomes2 = List.of("Ana","Alice","Bruno","Bia","Beto","Carla");
        Map<Character, Long> mapa = nomes2.stream()
                .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0)), Collectors.counting()
                ));
        System.out.println(mapa);

        List<Integer> ns = List.of(2,3,4,5,6,7,8,9,10,11);
        Map<Boolean, List<Integer>> part = ns.stream()
                .collect(Collectors.partitioningBy(StreamsPlayground::isPrime));

        System.out.println(part);

        List<List<Integer>> m = List.of(List.of(5,1,2), List.of(2,9), List.of(9,7,6));
        List<Integer> top3 = m.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println(top3); // [9, 7, 5]

        List<Pedido> pedidos = List.of(
                new Pedido("Ana", 100), new Pedido("Ana", 80),
                new Pedido("Bruno", 50), new Pedido("Ana", 20),
                new Pedido("Bruno", 70)
        );

        Map<String, Double> totalPorCliente = pedidos.stream()
                .collect(Collectors.groupingBy(
                        Pedido::cliente,
                        Collectors.summingDouble(Pedido::valor))
                );
        System.out.println(totalPorCliente); // {Ana=200.0, Bruno=120.0}




    }
    record Pedido(String cliente, double valor) {}
}
