package Sort;

public class MergerTwoSortedLists21 {
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

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;

            ListNode head = null;
            ListNode luuToaDo = null;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    if (head == null) { // first time
                        head = list1;
                        luuToaDo = list1;
                        list1 = list1.next;
                    } else { // sau đó
                        luuToaDo.next = list1;
                        luuToaDo = list1; // hay luuToaDo = luuToaDo.next;
                        list1 = list1.next;
                    }
                } else { // list2.val < list1.val
                    if (head == null) { // first time
                        head = list2;
                        luuToaDo = list2;
                        list2 = list2.next;
                    } else { // sau đó
                        luuToaDo.next = list2;
                        luuToaDo = list2; // hay luuToaDo = luuToaDo.next;
                        list2 = list2.next;
                    }
                }
            }

            // Sau khi thoát vòng while, thì sẽ xảy ra trường hợp
            // nếu list1 dài hơn list2 -> phần còn lại sẽ là của list1
            if (list1 != null) {
                luuToaDo.next = list1;
            }
            // nếu list2 dài hơn list1 -> phần còn lại sẽ là của list2
            if (list2 != null) {
                luuToaDo.next = list2;
            }
            return head;
        }
    }
}
