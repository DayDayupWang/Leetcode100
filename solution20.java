import java.util.HashMap;
import java.util.Stack;

public class solution20 {
    public static void main(String[] args) {
        String s = "(])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> symbolMap = new HashMap<Character, Character>();
        symbolMap.put(')', '(');
        symbolMap.put('}', '{');
        symbolMap.put(']', '[');

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != symbolMap.get(c)) {
                    break;
                } else {
                    stack.pop();
                    continue;
                }
            }

        }

        return stack.isEmpty();
    }
}
