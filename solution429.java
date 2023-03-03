import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class solution429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> que = new LinkedList<Node>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            que.offer(root);
        }

        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            while (size > 0) {
                Node tmpNode = que.poll();

                al.add(tmpNode.val);
                for (int i = 0; i < tmpNode.children.size(); i++) {
                    que.offer(tmpNode.children.get(i));
                }
                size--;
            }
            result.add(al);
        }

        return result;
    }

    public List<List<Integer>> oldlevelOrder(TreeNode root) {
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
