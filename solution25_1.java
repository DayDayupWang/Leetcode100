public class solution25_1 {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            // 让tail移动到待翻转的尾部
            while (tail != null && count < k) {
                count++;
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }

            ListNode followHead = tail.next;
            while (prev.next != tail) {
                ListNode curr = prev.next;
                prev.next = curr.next;
                curr.next = tail.next;
                tail.next = curr;
            }
            prev = followHead;
            tail = followHead;
        }
        return dummy.next;
    }

}
