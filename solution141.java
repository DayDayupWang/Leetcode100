import java.util.HashSet;

public class solution141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        int pos = -1;
        while (dummy.next != null) {
            dummy = dummy.next;
            pos++;
            if (set.contains(dummy)) {
                return true;
            }
            set.add(dummy);

        }
        return false;
    }
}
