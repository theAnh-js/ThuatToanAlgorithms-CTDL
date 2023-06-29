package StackQueue;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> mainStack = new Stack<>();

        Stack<Integer> reverseStack = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            mainStack.push(x);
        }

        public int pop() {
            if (reverseStack.isEmpty() == false) {
                return reverseStack.pop();
            } else {
                while (mainStack.isEmpty() == false) {
                    reverseStack.push(mainStack.pop());
                }
            }
            return reverseStack.pop();
        }

        public int peek() {
            if (reverseStack.isEmpty() == false) {
                reverseStack.peek();
            } else {
                while (mainStack.isEmpty() == false) {
                    reverseStack.push(mainStack.pop());
                }
            }
            return reverseStack.peek();
        }

        public boolean empty() {
            return mainStack.isEmpty() && reverseStack.isEmpty();
        }
    }
}
