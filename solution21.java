
public class solution21 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(4);
        l1.next = l11;
        l11.next = l111;
        ListNode list1 = l1;
        ListNode list2 = new ListNode();
        ListNode nwe = mergeTwoLists(list1, list2);

        while (nwe.next != null) {
            System.out.println(nwe.val);
            nwe = nwe.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
if (list1==null) {
    return list2;
}
if (list2==null) {
    return list1;
}
        ListNode answer = new ListNode();
        ListNode head = answer;// head指向answer的头节点

        while (list1 != null || list2 != null) {
            if (list1.next == null && list2.next == null) {// 没有可添加的数字时
                return head.next;
            } else {
                // 如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
                int x = list1 != null ? list1.val : 0;
                // 如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
                int y = list2 != null ? list2.val : 0;
                if (x >= y) {
                    answer.next = new ListNode(y);
                    if (list2.next != null) {
                        list2 = list2.next;
                    }

                } else {
                    answer.next = new ListNode(x);
                    if (list1.next != null) {
                        list1 = list1.next;
                    }

                }
                answer = answer.next;
            }

        }

        return answer;
    }
}