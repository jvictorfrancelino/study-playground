package vacation.challenges1301.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String s = sc.next();
            Deque<Character> stack = new ArrayDeque<>();

            boolean ok = true;

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        ok = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                        ok = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) ok = false;

            System.out.println(ok);
        }
    }
}
