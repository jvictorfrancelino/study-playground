package negativesubarray;

import java.util.Scanner;

public class Solution {
    public static void main (String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int n = scan.nextInt();
            int[] array1 = new int[n];

            for(int i = 0; i < n;i++){
                array1[i] = scan.nextInt();
            }
            int count = 0;

            for (int j = 0; j < n; j++){
                int sum = 0;
                for (int k = j; k < n; k++){
                    sum = array1[k] + sum;
                    if(sum < 0){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
