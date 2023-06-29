package StackQueue;

public class MyMain {
    public static void main(String[] args) {
        MyArrayStack myStack = new MyArrayStack(5);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.push(6)); // false vì myStack đã đầy, ko thể push thằng thứ 6
        myStack.show();

        System.out.println("-----------");
        myStack.pop();
        myStack.show();

        myStack.pop();
        myStack.show();

        myStack.pop();
        myStack.show();

    }

}
