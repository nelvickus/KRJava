import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
       
        System.out.println(F("()"));          // true
        System.out.println(F("(()()((())))")); // true
        System.out.println(F("(((()))()"));   // false
    }

    public static boolean F(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch); 
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; 
                }
                stack.pop(); 
            }
        }

        return stack.isEmpty(); 
    }
}
