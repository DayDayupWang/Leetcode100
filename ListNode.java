
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {// 新建一个链表，节点为对应数值
        this.val = val;
    }

    ListNode(int val, ListNode next) {// 嵌套的方法连接链表
        this.val = val;
        this.next = next;
    }
}
