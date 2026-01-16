package vacation.challenges0701.substring;

import java.util.Scanner;

public class Solution1 {
    static void main() {
        Scanner sc=new Scanner(System.in);
        String a =sc.next();

        StringBuilder sb = new StringBuilder(a);

        if(sb.reverse().toString().equals(a)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
