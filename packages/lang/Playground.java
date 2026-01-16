package packages.lang;

public class Playground {
    static void main() {
        // Object - classe mãe

        Object o = new Object();
        System.out.println(o.toString());

        String a = new String("java");
        String b = new String("java");

        System.out.println(a.equals(b)); // true
        System.out.println(a == b); // false

        String s = "java";
        System.out.println(s.hashCode()); // Retorna um número usado por estruturas hash (HashMap, HashSet)

        Object o2 = "teste";
        System.out.println(o2.getClass()); // Saída: class java.lang.String

        // String - imutável

        String s2 = "Java";
        System.out.println(s.length()); // 4

        System.out.println("Java".charAt(1)); // 'a'

        System.out.println("java".equals("java")); // true - compara conteúdo

        System.out.println("JAVA".equalsIgnoreCase("java")); // true

        System.out.println("HackerRank".substring(0, 6)); // Hacker

        System.out.println("Java".toUpperCase()); // JAVA
        System.out.println("Java".toLowerCase()); // java

        System.out.println("Java".contains("av")); // true

        String x = "java";
        String y = "ja" + "va";

        System.out.println(x == y); // true (pool)

        // Wrappers (Integer, Long, etc.)

        Integer i = 10; // autoboxing
        int x2 = i; // unboxing

        int n = Integer.parseInt("123");
        System.out.println(n);

        Integer c = 127;
        Integer d = 127;
        System.out.println(a == b); // true

        Integer e = 128;
        Integer f = 128;
        System.out.println(e = f); // false - Cache vai de -128 a 127

        // Math - Funções matemáticas

        System.out.println(Math.abs(-10)); // 10

        System.out.println(Math.max(10, 20)); // 20

        System.out.println(Math.sqrt(16)); // 4.0

        System.out.println(Math.round(10.6)); // 11

        System.out.println(Math.PI);

        // System

        System.out.println(); // Print padrão de linha

        System.out.println("Erro!");

        long now = System.currentTimeMillis();
        System.out.println(now);

        //System.exit(0);
        // nada depois executa

        // Exceções (RuntimeException)

        String s3 = null;
        System.out.println(s3.length()); // NullPointerException

        Object o3 = "abc";
        Integer i2 = (Integer) o3; // ClassCastException

        int[] arr = new int[2];
        System.out.println(arr[3]); // ArrayIndexOutOfBoundsException




    }
}
