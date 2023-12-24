package LinkedList;

public class LinkedListCycle {

    public class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        final int STEP = 2; // bước nhảy cho fastNode
        while (slowNode != null) {
            int count = 0;
            while (fastNode != null) {
                fastNode = fastNode.next;
                count++;
                if (count == STEP) {
                    break;
                }
            }
            if (fastNode == slowNode) { // khi 2 thằng node slow và fast gặp nhau
                // --> cycle list.
                return true;
            }

            slowNode = slowNode.next;
        }
        return false;
    }
}
