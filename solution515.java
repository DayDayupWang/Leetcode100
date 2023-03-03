import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class solution515 {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            que.offer(root);
        }
        while (!que.isEmpty()) {
            int size = que.size();
            int al = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode tmpNode = que.poll();

                al = tmpNode.val > al ? tmpNode.val : al;
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
