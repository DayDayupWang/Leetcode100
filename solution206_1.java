public class solution206_1 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        ListNode dummy = null;

        ListNode curr = head;
        while (head != null) {
            head = head.next;
            curr.next = dummy;
            dummy = curr;
            curr = head;
        }
        return dummy;
    }

    public ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null) {
			return head;
		}
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (dummy.next != tail) {
            ListNode curr = dummy.next;
            dummy.next = curr.next;
            curr.next = tail.next;
            tail.next = curr;
        }
        return dummy.next;
    }
}
