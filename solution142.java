import java.util.HashSet;

public class solution142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode copyA = new ListNode(-1);

        copyA.next = head;

        HashSet<ListNode> nodes = new HashSet<ListNode>();

        while (copyA != null) {
            copyA = copyA.next;
            if (nodes.contains(copyA)) {
                return copyA;
            }
            nodes.add(copyA);// 不存在这个节点，往下继续添加
        }
        return null;
    }
}
