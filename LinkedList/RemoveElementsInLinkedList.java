package LinkedList;

public class RemoveElementsInLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode preNode = null;
        ListNode curNode = head;

        // duyet linkedlist
        while (curNode != null) {
            boolean isFound = false;
            if (curNode.val == val) {
                isFound = true;
                if (preNode == null) { // truong hop tìm thấy val ngay ở đầu list or list này chỉ có 1 node
                                       // mà val của node đó là val cần remove.
                    head = curNode.next; // thì head sẽ bắt đầu từ node sau đó(nếu có nhiều node nữa),
                                         // hoặc head sẽ trở thành null(nếu list này chỉ có 1 node duy nhât)
                } else {
                    preNode.next = curNode.next; // bình thường preNode.next sẽ trỏ đến curNode,
                    // nhưng do curNode là node cần remove nên nó sẽ ko trỏ đến curNode nữa,
                    // mà trỏ đến node sau curNode.
                }
            }
            // Tiến preNode và curNode lên.
            // Nếu tìm thấy val thì vị trí của preNode vẫn giữ nguyên, còn next của nó thì
            // sẽ thay vì trỏ
            // vào curNode, next của nó sẽ trỏ vào next của curNode.(nghĩa là curNode is
            // removed)
            if (isFound == false) { // còn nếu ko phải node của xóa thì dịch preNode lên trên(bằng vs curNode)
                // còn nếu isFound là true rồi thì vị trí của preNode vẫn giữa nguyên, chỉ thay
                // đổi preNode.next thui, vì lúc này isFound == true nghĩa là curNode là node
                // cần remove.
                preNode = curNode;
            }
            curNode = curNode.next; // còn curNode thì dịch lên trên nữa.
        }
        return head; // vi head dai dien cho ca list
    }

    public static void main(String[] args) {

    }
}