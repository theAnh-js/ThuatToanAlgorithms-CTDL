package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    static class MyStack {
        Queue<Integer> mainQueue = new LinkedList<Integer>();
        Queue<Integer> secondQueue = new LinkedList<Integer>();

        public MyStack() { // đây là contructor mặc định

        }

        public void push(int x) {
            mainQueue.add(x);
        }

        public int pop() {
            int value = -1;
            while (mainQueue.isEmpty() == false) {
                if (mainQueue.size() == 1) { // đây sẽ là thằng cuối mảng, và ta remove nó giống pop của stack.
                    value = mainQueue.remove();
                } else { // đổ các phần tử của mainQueue sang secondQueue đến khi chỉ
                         // còn1 phần tử duy nhất sót lại ở mainQueue để remove
                    secondQueue.add(mainQueue.remove());
                }
            }
            // xong while loop thì mainQueue sẽ rỗng, và secondQueue sẽ có các phần tử
            // còn lại(trừ thằng bị remove), nên ta
            // đổi chỗ mainQueue và secondQueue cho nhau để chỉ phải làm vc trên thằng
            // mainQueue thoi.
            Queue<Integer> temp = mainQueue;
            mainQueue = secondQueue;
            secondQueue = temp;

            return value;
        }

        public int top() { // thằng lấy ra này giống thằng pop ở trên nhưng ko xóa.
            int value = -1;
            while (mainQueue.isEmpty() == false) {
                if (mainQueue.size() == 1) {
                    value = mainQueue.remove();
                    secondQueue.add(value); // trả lại vì hàm top() không xóa mà chỉ lấy ra phần tử thoi.
                } else {
                    secondQueue.add(mainQueue.remove());
                }
            }

            Queue<Integer> temp = mainQueue;
            mainQueue = secondQueue;
            secondQueue = temp;

            return value;
        }

        public boolean empty() {
            return mainQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());// 3
        System.out.println(stack.pop());// 2
        System.out.println(stack.pop());// 1
    }
}
