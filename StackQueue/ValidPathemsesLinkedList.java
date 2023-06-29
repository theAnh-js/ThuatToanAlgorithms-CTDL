package StackQueue;

public class ValidPathemsesLinkedList {

    class MyStack {
        class Node {
            Node next;
            char value;

            Node(char c) {
                this.value = c;
                this.next = null;
            }
        }

        Node topNode;

        public void push(char c) {
            Node newNode = new Node(c);
            if (isEmpty()) {
                topNode = newNode;
            } else {
                newNode.next = topNode;
                topNode = newNode;
            }
        }

        public char pop() {
            char c = topNode.value;
            topNode = topNode.next;

            return c;

        }

        public boolean isEmpty() {
            return topNode == null;
        }
    }

    public boolean isValid(String s) {
        int n = s.length();
        MyStack myStack = new MyStack();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) {
                    return false;
                } else {
                    char lastChar = myStack.pop(); // lấy ra thằng ở trên đầu của stack ra
                    if (lastChar == '{' && c == '}' || lastChar == '[' && c == ']' || lastChar == '(' && c == ')') {
                        // ok, no code :))
                    } else {
                        return false;
                    }
                }
            }

        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidPathemsesLinkedList VPL = new ValidPathemsesLinkedList();
        String s = "({})[]";
        System.out.println(VPL.isValid(s));
        String s1 = "(})[]";
        System.out.println(VPL.isValid(s1));
        String s2 = "({})[";
        System.out.println(VPL.isValid(s2));
        String s3 = "()[]";
        System.out.println(VPL.isValid(s3));
    }

}
