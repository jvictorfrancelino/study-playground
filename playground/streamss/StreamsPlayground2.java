package playground.streamss;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPlayground2 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int r = nums.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(r);
        //Return 1^2 + 3^3 = 10

        Map<Integer, Long> res =
                Stream.of("a","bb","ccc","dd","e")
                        .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(res);
        //Return {a=2, 2=2, 3=1} (Map<Integer, Long>)

        List<List<Integer>> data = List.of(List.of(1,2,3), List.of(3,1));
        List<Integer> out = data.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();
        System.out.println(out);
        //Return [1, 2, 3]

        Map<String, Integer> m =
                Stream.of("a", "bb", "a")
                        .collect(Collectors.toMap(s -> s, String::length));
        //Return IllegalStateException por chave duplicada "a"

        AtomicInteger counter = new AtomicInteger();
        boolean found = IntStream.rangeClosed(1, 1_000_000)
                .peek(n -> counter.incrementAndGet())
                .anyMatch(n -> n == 5);

        System.out.println(counter.get());
        //Return 5 curto-circuito ao encontrar 5; peek contou 5 elementos.

        System.out.println(IntStream.range(1, 5).boxed().toList()); // [1, 2, 3, 4]
        System.out.println(IntStream.rangeClosed(1, 5).boxed().toList()); // [1, 2, 3, 4, 5]
        // IntStream.range(a, b): vai de a até b-1 (b é exclusivo)
        // IntStream.rangeClosed(a, b): vai de a até b (b é inclusivo)

        AtomicInteger seen = new AtomicInteger();

        List<Integer> out2 = List.of(1, 2, 3)
                .stream()
                .peek(n -> seen.incrementAndGet()) // "espiada" em cada elemento
                .map(n -> n * 10)
                .toList();

        System.out.println(out2); // [10, 20, 30]
        System.out.println(seen.get()); // 3
        //peek é uma operação intermediária para debug/telemetria (log, contagem)
        //Evite usar peek para lógica essencial (efeitos colaterais); prefira map, filter e forEach no final

        AtomicInteger counter2 = new AtomicInteger();

        boolean found2 = IntStream.rangeClosed(1, 1_000_000)
                .peek(n -> counter2.incrementAndGet())
                .anyMatch(n -> n == 5);

        System.out.println(found2);
        System.out.println(counter.get());

        System.out.println(IntStream.of(2, 4, 6).allMatch(n -> n % 2 == 0)); // true
        System.out.println(IntStream.of(1, 3, 5).noneMatch(n -> n % 2 == 0)); // true
        //anyMatch(P): true se algum elemento satisfaz P. Para no primeiro que satisfaz (curto-circuito)
        //allMatch(P): true se todos satisfazem P. Para no primeiro que não satisfaz
        //noneMatch(P): tue se nenhum satisfaz P. Para no primeiro que satisfaz

        // findFirst / findAny (retornam Optional)
        Optional<Integer> f1 = IntStream.of(3, 2, 1).boxed().findFirst(); // 3
        Optional<Integer> fa = IntStream.of(3, 2, 1).boxed().findAny(); // em paralelo, pode não ser o primeiro

        // limit / skip (controle de janela)
        List<Integer> page = IntStream.rangeClosed(1, 100)
                .skip(10)
                .limit(5)
                .boxed()
                .toList(); // [11..15]

        // distinct / sorted
        List<Integer> uniqSorted = Stream.of(3,1,2,2,1)
                .distinct()
                .sorted()
                .toList(); // [1,2,3]

        // count (terminal), sum/average em streams primitivos
        long c = IntStream.range(1, 5).count(); // 4
        int sum = IntStream.rangeClosed(1, 5).sum(); // 5

        // forEach vs forEachOrdered
        Stream.of("b", "a", "c")
                .parallel()
                .forEachOrdered(System.out::print); // garante ordem: "bac" ? -> "bac"


    }
}
