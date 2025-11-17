package playground;

import java.util.Arrays;

public class ArraysPlayground2 {
    public static int[] removeEven(int[] originalArray) {
        // Count the number of odd elements to determine the size of the array
        int oddCount = 0;
        for (int num : originalArray) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        // Create a new array to store only the odd numbers
        int[] newArray  = new int[oddCount];
        int index = 0;
        for (int num : originalArray){
            if (num % 2 != 0){
                newArray[index] = num;
                index++;
            }
        }
        return newArray;

    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original array: " + Arrays.toString(numbers));

        int [] oddNumbers = removeEven(numbers);
        System.out.println("Array afeter remove even numbers:" + Arrays.toString(oddNumbers));
    }
}