import java.lang.reflect.Method;

import org.xml.sax.ext.Locator2;

public class solution203 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(7);
        // while (l1!= null) {
        // System.out.println(l1.val);
        // l1 = l1.next;
        // }
        ListNode l2 = removeElements(l1, 6);
        while (l2 != null) {

            System.out.println(l2.val);
            l2 = l2.next;
        }

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 头不为空则创建头节点
        ListNode newHead = new ListNode();
        ListNode res = newHead;// 用于返回的头节点，从0开始

        // while (head != null) {
        // if (head.val == val) {
        // head = head.next;// 原链表取下个元素
        // continue;// 假如取到了要跳过的就continue
        // }
        // newHead.next = new ListNode(head.val);
        // newHead = newHead.next;
        // head = head.next;
        // }
        Recursion(newHead, head, val);

        return res.next;
    }

    public static void Recursion(ListNode l1, ListNode l2, int val) {
        if (l2 == null) {
            return;
        }
        if (l2.val == val) {
            l2 = l2.next;
            Recursion(l1, l2, val);
        } else {

            l1.next = new ListNode(l2.val);
            l1 = l1.next;
            l2 = l2.next;
            Recursion(l1, l2, val);
        }

    }
}
