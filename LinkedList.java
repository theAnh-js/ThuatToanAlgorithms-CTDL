public class LinkedList {

    // Singly Linked List: danh sách liên kết đơn
    // Yêu cầu:
    // - Biết sử dụng struct/class trong C/C++ hoặc class java
    // - Phân biệt được reference type và value/primitive type trong java
    // hoặc biết cách sử dụng con trỏ trong C/C++

    // Đặc điểm của Singly Linked List:
    // - chỉ cần lưu node đầu tiên(head) là có thể truy xuất cả mảng
    // - khả năng truy xuất 1 phần tử của mảng O(n)
    // - khả năng thêm và xóa 1 phần tử: O(1) - vị trí đó phải biết trước
    // nếu ko biết trước thì ta lại phải duyệt từ đầu đến cuối -> lúc này thành O(n)

    // thực tế ta phải tạo 1 class ở 1 file khác, ko làm chung thế này
    // đây để học thì ok
    public static class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }

    }

    public static Node addToHead(Node headNode, int value) {
        Node newNode = new Node(value);
        if (headNode == null) {
            return newNode;
        } else {
            newNode.next = headNode;
            return newNode;
        }
    }

    public static Node addToTail(Node headNode, int value) {

        Node newNode = new Node(value);
        if (headNode == null) {
            return newNode;
        } else {
            // cần xác định phần last-cuối cùng, khi đó lastNode.next = null
            Node lastNode = headNode;
            while (lastNode.next != null) { // khi vòng while dừng cũng là khi ta tìm được phần tử cuối
                lastNode = lastNode.next; // vì lúc này lastNode.next là null
            }
            // Trỏ thằng last vào newNode/ gán next cho lastNode bằng newNode
            lastNode.next = newNode;
        }
        return headNode;
    }

    public static Node addToIndex(Node headNode, int value, int index) {

        if (index == 0) {
            return addToHead(headNode, value);
        } else {
            // B1: tìm vị trí cần thêm
            Node newNode = new Node(value);
            Node curNode = headNode;
            int count = 0;
            while (curNode != null) {
                count++;
                if (count == index) {
                    // Thực hiện add
                    newNode.next = curNode.next; // đuôi của newNode chính là đuôi của curNode;
                    curNode.next = newNode; // trỏ newNode làm phần tử tiếp theo của curNode
                    break;
                }
                curNode = curNode.next;
            }
        }
        return headNode;
    }

    public static Node removeAtHead(Node headNode) {
        if (headNode != null) { // nếu haedNode khác null
            return headNode.next; // thì ta trỏ thằng sau headNode làm headNode
        }
        return headNode; // còn nếu headNode là null thì chỉ cần trỏ null vào là ok
    }

    public static Node removeAtTail(Node headNode) {

        if (headNode == null) {
            return null;
        }
        // B1: xác định last và previous
        Node lastNode = headNode;
        Node preNode = null;

        while (lastNode.next != null) { // khi lastNode chưa phải node cuối
            preNode = lastNode;
            lastNode = lastNode.next;
        }

        if (preNode == null) { // chứng tỏ nó ko vào vòng while trên
            // nghĩa là lastNode là lastNode sẵn rồi, và list này chỉ có 1 node thoi
            return null; // vì có mỗi 1 node mà ta lại remove nó nên nó sẽ thành null
        } else {
            preNode.next = lastNode.next; // bẻ mắt xích để thằng preNode.next là null
        }

        return headNode;
    }

    public static Node removeAtIndex(Node headNode, int index) {
        if (headNode == null || index < 0) {
            return null;
        }
        if (index == 0) {
            return removeAtHead(headNode);
        }

        Node curNode = headNode;
        Node preNode = null;
        int count = 0;
        boolean isFound = false;
        // Lại sử dụng kĩ thuật 2 con trỏ giống addAtIndex
        while (curNode != null) {
            if (count == index) {
                // remove curNode
                isFound = true;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
            count++;
        }

        // remove
        if (isFound) {
            if (preNode == null) { // chứng tỏ current node là last node
                return null;
            } else {
                if (curNode != null) {
                    preNode.next = curNode.next;
                }
            }
        }

        return headNode;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1); // 1 node này cũng được coi là 1 linkedlist, có chút hơi giống đệ quy
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        printLinkedList(n1);
        // printLinkedList(n2);
        // printLinkedList(n3);
        // printLinkedList(null);

        // Node newList = addToHead(n1, 0);
        // printLinkedList(newList);

        // n1 = addToHead(n1, 0);
        // n1 = addToTail(n1, 4);
        // printLinkedList(n1);

        n1 = addToIndex(n1, 0, 0);
        printLinkedList(n1);
        n1 = addToIndex(n1, 4, 4);
        printLinkedList(n1);
        n1 = addToIndex(n1, 5, 2);
        printLinkedList(n1);

        n1 = removeAtHead(n1);
        printLinkedList(n1);

        System.out.println("---------");
        n1 = removeAtTail(n1);
        printLinkedList(n1);
        n1 = removeAtTail(n1);
        printLinkedList(n1);

        System.out.println("---------");
        n1 = removeAtIndex(n1, 1);
        printLinkedList(n1);
        n1 = removeAtIndex(n1, 1);
        printLinkedList(n1);
    }
}
