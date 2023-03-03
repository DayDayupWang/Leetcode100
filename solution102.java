import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class solution102 {
    public static void main(String[] args) {

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

                al.add(tmpNode.val); // 需要关注的输出操作
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
