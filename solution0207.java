import java.util.HashSet;

public class solution0207 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode copyA = new ListNode(-1);
        ListNode copyB = new ListNode(-1);
        copyA.next = headA;
        copyB.next = headB;

        HashSet<ListNode> nodes = new HashSet<ListNode>();
        while (copyA != null) {
            copyA = copyA.next;
            nodes.add(copyA);
        }
        while (copyB != null) {
            copyB = copyB.next;
            if (nodes.contains(copyB)) {// 假如存在同节点则返回这个节点，不然继续直到结束
                return copyB;
            }
        }
        return null;
    }
}
