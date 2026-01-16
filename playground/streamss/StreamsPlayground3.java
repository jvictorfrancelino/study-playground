package playground.streamss;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsPlayground3 {
    public static void main(String[] args) {
        exemplo1FiltroSimples();
        exemplo2MapUpperCase();
        exemplo3MapToIntESoma();
        exemplo4DistinctESorted();
        exemplo5SkipELimit();
        exemplo6AnyAllNoneMatch();
        exemplo7FindFirstOrElse();
        exemplo8ReduceSoma();
        exemplo9GroupingByCampo();
        exemplo10GroupingByCounting();
        exemplo11PartitioningBy();
        exemplo12Joining();
        exemplo13FlatMap();
        exemplo14CollectingAndThen();
        exemplo15SummarizingInt();
        exemplo16ToMap();
        exemplo17SortedCustomComparator();
        exemplo18ParallelStream();
        exemplo19PeekParaDebug();
        exemplo20StreamEmMapEntries();
    }

    // 1) filter + toList
    private static void exemplo1FiltroSimples() {
        List<Integer> numeros = List.of(1, 2, 3, 10, 20, 30);

        List<Integer> maioresQueDez = numeros.stream()
                .filter(n -> n > 10)
                .toList();

        System.out.println("Exemplo 1 - maioresQueDez: " + maioresQueDez);
    }

    // 2 - map: transformar strings em maiúsculas
    private static void exemplo2MapUpperCase() {
        List<String> nomes = List.of("victor", "java", "stream");

        List<String> upper = nomes.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Exemplo 2 - upper: " + upper);
    }

    // 3 - mapToInt + sum
    private static void exemplo3MapToIntESoma() {
        List<String> numerosTexto = List.of("1", "2", "3", "10");

        int soma = numerosTexto.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Exemplo 3 - soma: " + soma);
    }

    // 4 - distinct + sorted
    private static void exemplo4DistinctESorted(){
        List<Integer> numeros = List.of(5, 1, 3, 3, 2, 1, 10);

        List<Integer> ordenadosSemDuplicata = numeros.stream()
                .distinct()
                .sorted()
                .toList();

        System.out.println("Exemplo 4 - ordenadosSemDuplicata: " + ordenadosSemDuplicata);
    }

    // 5 - skip + limit (paginação simples)
    private static void exemplo5SkipELimit() {
        List<Integer> numeros = IntStream.rangeClosed(1, 20)
                .boxed()
                .toList();

        int pagina = 2;
        int tamanhoPagina = 5;

        List<Integer> pagina2 = numeros.stream()
                .skip((long) (pagina - 1) * tamanhoPagina)
                .limit(tamanhoPagina)
                .toList();

        System.out.println("Exemplo 5 - pagina2: " + pagina2);
    }

    // 6 - anyMatch, allMatch, noneMatch
    private static void exemplo6AnyAllNoneMatch() {
        List<Integer> numeros = List.of(2, 4, 6, 8, 10);

        boolean algumImpar = numeros.stream()
                .anyMatch(n -> n % 2 != 0);

        boolean todosPares = numeros.stream()
                .allMatch(n -> n % 2 == 0);

        boolean nenhumMaiorQueCem = numeros.stream()
                .noneMatch(n -> n > 100);

        System.out.println("Exemplo 6 - algumImpar: " + algumImpar);
        System.out.println("Exemplo 6 - todosPares: " + todosPares);
        System.out.println("Exemplo 6 - nenhumMaiorQueCem: " + nenhumMaiorQueCem);
    }

    // 7) findFirst + orElse
    private static void exemplo7FindFirstOrElse() {
        List<String> nomes = List.of("Ana", "Bruno", "Carlos", "Amanda");

        String nomeQueComecaComA = nomes.stream()
                .filter(n -> n.startsWith("A"))
                .findFirst()
                .orElse("Nenhum nome comeca com A");

        System.out.println("Exemplo 7 - nomeQueComecaComA: " + nomeQueComecaComA);

    }

    // 8 - reduce para somar (forma mais manual)
    private static void exemplo8ReduceSoma() {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        int soma = numeros.stream()
                .reduce(0, Integer::sum);

        System.out.println("Exemplo 8 - soma: " + soma);
    }

    // Classe auxiliar para alguns exemplos
    private static class Pessoa {
        private final String nome;
        private final int idade;
        private final String cidade;

        public Pessoa(String nome, int idade, String cidade) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
        }

        public String getNome(){
            return nome;
        }

        public int getIdade(){
            return idade;
        }

        public String getCidade(){
            return cidade;
        }

        @Override
        public String toString(){
            return "Pessoa{" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", cidade='" + cidade + '\'' +
                    '}';
        }
    }

    // 9 - groupingBy: agrupar pessoas por cidade
    private static void exemplo9GroupingByCampo() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", 25, "São Paulo"),
                new Pessoa("Bruno", 30, "Rio de Janeiro"),
                new Pessoa("Carlos", 40, "São Paulo"),
                new Pessoa("Daniela", 35, "Curitiba")
        );

        Map<String, List<Pessoa>> pessoasPorCidade = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getCidade));

        System.out.println("Exemplo 9 - pessoasPorCidade: " + pessoasPorCidade);
    }

    // 10 - groupingBy + counting: contagem por cidade
    private static void exemplo10GroupingByCounting(){
        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", 25, "São Paulo"),
                new Pessoa("Bruno", 30, "Rio de Janeiro"),
                new Pessoa("Carlos", 40, "São Paulo"),
                new Pessoa("Daniela", 35, "Curitiba")
        );

        Map<String, Long> contagemPorCidade = pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCidade,
                        Collectors.counting()
                ));

        System.out.println("Exemplo 10 - contagemPorCidade: " + contagemPorCidade);
    }

    // 11 - partitioningBy: separar maiores e menores de idade
    private static void exemplo11PartitioningBy() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", 17, "São Paulo"),
                new Pessoa("Bruno", 18, "Rio de Janeiro"),
                new Pessoa("Carlos", 16, "São Paulo"),
                new Pessoa("Daniela", 25, "Curitiba")
        );

        Map<Boolean, List<Pessoa>> maioresDeIdade = pessoas.stream()
                .collect(Collectors.partitioningBy(p -> p.getIdade() >= 18));

        System.out.println("Exemplo 11 - maioresDeIdade: " + maioresDeIdade);
    }

    // 12 - joining: concatenar strings
    private static void exemplo12Joining() {
        List<String> nomes = List.of("Java", "Stream", "API");

        String resultado = nomes.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Exemplo 12 - resultado: " + resultado);
    }

    // 13 - flatMap: transformar List<List<T>> em List<T>
    private static void exemplo13FlatMap() {
        List<List<String>> listaDeListas = List.of(
                List.of("A", "B"),
                List.of("C", "D", "E")
        );

        List<String> achatado = listaDeListas.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Exemplo 13 - achatado: " + achatado);
    }

    // 14 - collectingAndThen: pós-processar resultado da coleção
    private static void exemplo14CollectingAndThen(){
        List<String> nomes = List.of("java", "stream", "api");

        List<String> imutavelUpper = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println("Exemplo 14 - imutavelUpper: " + imutavelUpper);
    }

    // 15 - summarizingInt: estatísticas de números
    private static void exemplo15SummarizingInt() {
        List<Integer> numeros = List.of(10, 20, 30, 40);

        IntSummaryStatistics stats = numeros.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Exemplo 15 - stats: " + stats);
        System.out.println("Exemplo 15 - média: " + stats.getAverage());
    }

    // 16 - toMap: transformar lista em Mapa
    private static void exemplo16ToMap(){
        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", 25, "São Paulo"),
                new Pessoa("Bruno", 30, "Rio de Janeiro"),
                new Pessoa("Carlos", 40, "São Paulo")
        );

        Map<String, Integer> idadePorNome = pessoas.stream()
                .collect(Collectors.toMap(
                        Pessoa::getNome,
                        Pessoa::getIdade
                ));
        System.out.println("Exemplo 16 - idadePorNome: " + idadePorNome);
    }

    // 17 - sorted com comparator customizado
    private static void exemplo17SortedCustomComparator() {
        List<Pessoa> pessoas = List.of(
            new Pessoa("Ana", 25, "São Paulo"),
            new Pessoa("Bruno", 30, "Rio de Janeiro"),
            new Pessoa("Carlos", 20, "São Paulo")
        );

        List<Pessoa> ordenadoPorIdadeDesc = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .toList();
        System.out.println("Exemplo 17 - ordenadoPorIdadeDesc: " + ordenadoPorIdadeDesc);
    }

    // 18 - parallelStream: processamento paralelo (ilustrativo)
    private static void exemplo18ParallelStream() {
        List<Integer> numeros = IntStream.rangeClosed(1, 20)
                .boxed()
                .toList();

        int soma = numeros.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Exemplo 18 - soma (parallelStream): " + soma);
    }

    // 19 - peek para debug em pipeline
    private static void exemplo19PeekParaDebug() {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        List<Integer> resultado = numeros.stream()
                .peek(n -> System.out.println("Antes do filter: " + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("Depois do filter (par): " + n))
                .map(n -> n * 10)
                .peek(n -> System.out.println("Depois do map (*10): "+ n))
                .toList();

        System.out.println("Exemplo 19 - resultado: " + resultado);
    }

    // 20 - trabalhando com Map usando entrySet().strema()
    private static void exemplo20StreamEmMapEntries(){
        Map<String, Integer> idadePorNome = new HashMap<>();
        idadePorNome.put("Ana", 25);
        idadePorNome.put("Bruno", 30);
        idadePorNome.put("Carlos", 40);

        List<String> nomesMaioresQue25 = idadePorNome.entrySet().stream()
                .filter(e -> e.getValue() > 25)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Exemplo 20 - nomesMaioresQue25: " + nomesMaioresQue25);
    }
}
