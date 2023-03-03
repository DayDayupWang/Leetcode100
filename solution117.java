import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class solution117 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                Node tmp = que.poll();

                if (size == 1) {
                    tmp.next = null;
                } else {
                    tmp.next = que.peek();
                }
                if (tmp.left != null) {
                    que.add(tmp.left);
                }
                if (tmp.right != null) {
                    que.add(tmp.right);
                }
                size--;
            }
        }
        return root;
    }
}
