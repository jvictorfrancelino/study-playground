package hackerrank.generics;

public class Solution {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // Integer array
        Integer[] intArray = {1, 2, 3};
        // String array
        String[] stringArray = {"Hello", "World"};

        // Call the generic printArray method for the integer array
        printer.printArray(intArray);

        // Call the generic printArray method for the string array
        printer.printArray(stringArray);
    }
}

class Printer {
    public <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}