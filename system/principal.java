package system;

import java.io.IOException;

public class principal {
    public static void main(String[] args) throws IOException {
        // Encoding: Para ler corretamente acentos, informe UTF-8 no InputStreamReader
        // Quebra de linha portável: use %n no printf/formal (em vez de \n)
        // Flush: println já flush-a com PrintWriter em autoFlush; se precisar, chame System.out.flush()
        // Log console: para aplicações reais, prefira logging (SLF4J/Logback/Log4j) ao invés de System.out.println

        String nome = "fulano";
        int idade = 18;

        System.out.print("sem quebra");
        System.out.println("com quebra");
        System.out.printf("Nome: %s | Idade: %d%n", nome, idade);

        System.out.format("PI ~ %.3f%n", Math.PI);

        System.out.println("algo deu errado");

        try(var out = new java.io.PrintWriter(System.out, true)) {
            out.println("Olá");
        }

        try(var sc = new java.util.Scanner(System.in)) {
            sc.useLocale(new java.util.Locale("pt", "BR"));
            System.out.print("Nome: ");
            String nome2 = sc.nextLine();

            System.out.print("Idade: ");
            int idade2 = sc.nextInt(); sc.nextLine(); // consome \n após nextInt

            System.out.print("Salário: ");
            double sal = sc.nextDouble();
        }

        try (var br = new java.io.BufferedReader(
                new java.io.InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8))) {

            System.out.print("Digite algo: ");
            String linha = br.readLine(); // sempre retorna String; depois você faz parse
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int b = System.in.read(); // lê 1 byte (-1 = EOF)


    }
}
