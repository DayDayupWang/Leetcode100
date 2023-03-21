import java.util.Stack;

public class solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        int count = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (true) {
            // 一次k个翻转
            ListNode start = head;
            while (head != null && count < k) {
                s1.add(head);
                count++;
                head = head.next;
            }
            // 不足k个退出循环
            if (count != k) {
                curr.next = start;
                break;
            }
            // 翻转
            while (!s1.isEmpty()) {
                curr.next = s1.pop();
                curr = curr.next;
                count--;
            }
            start.next = head;
        }

        return dummy.next;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;

            // 让tail移动到待翻转的尾部
            while (tail != null && count < k) {
                count++;
                tail = tail.next;
            }
            // 不足k个退出循环
            if (tail == null) {
                break;
            }
            ListNode head1 = pre.next;
            // 翻转
            while (pre.next != tail) {
                // prev 1 2 3
                // 创建一个用于调换的节点指向1;
                // 让prev接替1
                // 让1接替3
                // 让3指向1
                ListNode curr = pre.next;
                // 给pre新的待翻转头节点
                pre.next = curr.next;
                // 让插入到尾部的新节点指向原尾部的下一个节点
                curr.next = tail.next;
                // 让老尾部指向新尾部
                tail.next = curr;
            }
            pre = head1;
            tail = head1;
        }

        return dummy.next;
    }
}
