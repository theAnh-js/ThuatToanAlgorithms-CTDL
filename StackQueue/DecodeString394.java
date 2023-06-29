package StackQueue;

import java.util.Stack;

public class DecodeString394 {
    public static String decodeString(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) { // 3[abc]2[d]
            char c = s.charAt(i);
            if (c == ']') {
                String s1 = "";
                while (stack.peek() != '[') {
                    s1 = stack.pop() + s1;// vì là string nên cần chú ý thứ tự cộng vào
                    // nếu để là s1 += stack.pop() thì sẽ bị ngược
                }
                stack.pop(); // remove '['

                // get numberic char
                String s2 = "";
                while (stack.isEmpty() == false && Character.isDigit(stack.peek())) {
                    s2 += stack.pop(); // nếu để thế này thì với case 100[a], s2 = '0' + '0' + '1', cuối cùng = 1 và
                                       // chỉ repeat chữ a được 1 lần, cần chú ý thứ tự cộng string, phải là s2 =
                                       // stack.pop() + s2, thì s2 mới = '100' được, và a với được repeat 100 lần.

                }
                int numbericChar = Integer.parseInt(s2);
                s1 = s1.repeat(numbericChar);

                // add lại vào stack
                for (int j = 0; j < s1.length(); j++) {
                    stack.push(s1.charAt(j));
                }

            } else {
                stack.push(c);
            }

        }
        String result = "";
        while (stack.isEmpty() == false) {
            result = stack.pop() + result; // vì là string nên cần chú ý thứ tự cộng vào
            // nếu để là result += stack.pop() thì sẽ bị ngược
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(decodeString("3[abc]"));
        System.out.println(decodeString("3[abc]2[d]"));
        System.out.println(decodeString("3[a2[c]]"));
    }
}
