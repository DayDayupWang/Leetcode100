public class solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // 双指针法
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        ListNode preStart = dummy;
        // 找到位置

        while (left > 0) {
            start = start.next;
            if (left > 1) {
                preStart = preStart.next;
            }
            left--;
        }
        ListNode reversedEnd = start;
        while (right > 0) {
            end = end.next;
            right--;
        }

        ListNode reversedEndFollow = end.next;
        // 断开原来的连接
        preStart.next = null;
        end.next = null;
        // 翻转部分链表
        reverse(start);
        // 和原来的链表进行连接
        reversedEnd.next = reversedEndFollow;
        preStart.next = end;
        return dummy.next;

    }

    private void reverse(ListNode start) {
        ListNode dummy = null;
        ListNode curr = start;
        while (start != null) {
            start = start.next;
            curr.next = dummy;
            dummy = curr;
            curr = start;
        }

    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode start = dummy;
        ListNode end = dummy;
        ListNode preStart = dummy;
        // 双指针移动到指定位置
        while (left > 0) {
            start = start.next;
            if (left > 1) {
                preStart = preStart.next;
            }
            left--;
        }
        while (right > 0) {
            end = end.next;
            right--;
        }
        // 翻转
        while (preStart.next != end) {
            preStart.next = start.next;
            start.next = end.next;
            end.next = start;
            start = preStart.next;
        }
        // 连接？

        return dummy.next;
    }

}
