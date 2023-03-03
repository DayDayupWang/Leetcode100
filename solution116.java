import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

public class solution116 {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<Node>();
        Node res = root;// 给定返回的最终节点
        if (root != null) {
            que.offer(root);
        }
        while (!que.isEmpty()) {
            int size = que.size(); // 2

            while (size > 0) {
                Node tmpNode = que.poll();// que: 3 tmpNode=2
                if (size == 1) {
                    tmpNode.next = null;// 1 #
                } else {
                    tmpNode.next = que.peek();// 需要关注的输出操作
                }
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left); // 3 4
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);// 3 4 5
                }
                size--; // size==1
            }

        }

        return res;

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            que.offer(root);
        }
        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode tmpNode = que.poll();

                al.add(tmpNode.val);
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                size--;
            }
            result.add(al);
        }

        return result;
    }
}
