package by.it._khmelov_.jd01_12;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class TaskC3 {

    static boolean checkBrackets(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> brackets = Map.of('{', '}', '(', ')', '[', ']');
        for (char c : expression.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.addFirst(brackets.get(c));
            } else if (brackets.containsValue(c) && (stack.isEmpty() || stack.removeFirst() != c)) {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkBrackets(new Scanner(System.in).next()));
    }
}
