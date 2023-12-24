package LinkedList;

public class RemoveNthNodeFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = null;
        final int STEP = n + 1;
        int count = 0;
        while (first != null) {
            count++;
            if (count == STEP) {
                second = head;
            }

            if (first.next == null) {

                if (second == null) {
                    if (count == n) {
                        return head.next;
                    } else {
                        return head;
                    }
                } else {
                    if (second.next != null) {
                        second.next = second.next.next;
                    }
                }
            }
            first = first.next;
            second = second == null ? null : second.next;
        }

        return head;
    }

}
