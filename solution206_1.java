public class solution206_1 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode();
        ListNode curr = head;
        prev.next = curr;
        while (head != null) {
            head = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }

        return prev;
    }
}
