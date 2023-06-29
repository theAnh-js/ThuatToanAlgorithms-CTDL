package StackQueue;

import java.util.Stack;

public class MinStack155 {
    class MinStack {
        class Node {
            int value;
            int MIN;

            Node(int value) {
                this.value = value;
            }
        }

        Stack<Node> stack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            Node newNode = new Node(val);
            if (stack.isEmpty()) {
                newNode.MIN = newNode.value;
            } else {
                newNode.MIN = Math.min(newNode.value, stack.peek().MIN);
            }
            // có thể viết lại bằng toán tử 2 ngôi:
            // newNode.MIN = stack.isEmpty() ? val :
            // Math.min(newNode.value,tack.peek().MIN);
            stack.add(newNode);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return stack.peek().MIN;
        }
    }

    public static void main(String[] args) {
        MinStack155.MinStack ms = (new MinStack155()).new MinStack();

        ms.push(1);
        ms.push(0);
        ms.push(2);
        ms.push(-1);

    }
}
