package StackQueue;

public class MyArrayQueue implements IStackQueue {

    private int[] array;
    private int SIZE;
    private int headIndex;
    private int tailIndex;

    MyArrayQueue(int size) {
        SIZE = size;
        array = new int[SIZE];
        headIndex = tailIndex = -1;
    }

    @Override
    public boolean push(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                headIndex++;
            }
            tailIndex++;
            array[tailIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {

        int value = -1;
        if (!isEmpty()) {
            value = array[headIndex];
            headIndex++;
            if (headIndex > tailIndex) {
                headIndex = tailIndex = -1;
            }
        }

        return value;
    }

    @Override
    public boolean isEmpty() {
        return (headIndex == -1) && (tailIndex == -1);
    }

    @Override
    public boolean isFull() {
        return tailIndex == SIZE - 1;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public int count() {
        if (isEmpty()) {
            return 0;
        }
        return tailIndex - headIndex + 1;
    }

    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue(3);
        System.out.println(queue.push(1));
        queue.push(2);
        queue.push(3);
        queue.push(4);

        queue.show();

        queue.pop();

        queue.show();
    }
}
