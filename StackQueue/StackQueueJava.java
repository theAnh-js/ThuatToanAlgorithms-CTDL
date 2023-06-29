package StackQueue;

import java.util.Stack;

public class StackQueueJava {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        for (Integer x : myStack) {
            System.out.println(x);
        }

        System.out.println("peek: " + myStack.peek()); // peek lấy ra phần tử đầu của stack chứ ko xóa như pop
        System.out.println("pop: " + myStack.pop());
        System.out.println("pop: " + myStack.pop());

        System.out.println("Empty is: " + myStack.isEmpty());
        for (Integer x : myStack) {
            System.out.println(x);
        }
    }
}
