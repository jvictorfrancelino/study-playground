package strings.reverseString;

public class Debugging {
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        System.out.println(reverseString("josevictor"));
        System.out.printf("Time taken: %.3f ms%n", (System.nanoTime() - t0) / 1_000_000.0);
    }

    public static String reverseString(String word){
        if (word == null || word.isEmpty()) return null;
        char[] a = word.toCharArray();
        int i = 0, j = a.length -1;

        while (i < j) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;j--;
        }

        return new String(a);
    }
}