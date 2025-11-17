package strings.stringPalindrome;

public class Debugging {
    public static void main(String[] args){
        long t0 = System.nanoTime();
        System.out.println(isPalindromeTwoPointers("arara"));
        System.out.printf("Time taken: %.3f ms%n", (System.nanoTime() - t0) / 1_000_000.0);
    }

    public static boolean isPalindromeTwoPointers(String a){
        if(a == null || a.isEmpty()) return false;
        int i = 0; int j = a.length() - 1;

        while (i < j) {
            if(a.charAt(i) != a.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
