package hackerrank.balancedParenteses;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        for (char c : input.toCharArray()){
            // Se c == ( ou [ ou {
            if (c == '(' || c == '[' || c == '{') {
                // Adiciona char a stck
                stack.push(c);
            } else {
                // Se a stack está vazia retorna false
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    balanced = false;
                    break;
                }
            }
        }
        System.out.println(balanced && stack.isEmpty());
    }
}
