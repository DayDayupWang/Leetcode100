import javax.management.relation.Relation;

public class solution19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode preleft = res;
        ListNode left = res;
        int len = 0;
        while (head != null) {
            head = head.next;

            if (len < n) {// 记录走过的长度
                len += 1;
            } else if (len == n) {
                preleft = left;
                left = left.next;
            }

        }

        preleft.next = left.next;
        return res.next;
    }
}
