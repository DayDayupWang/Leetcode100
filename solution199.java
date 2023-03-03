import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class solution199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (root != null) {
            que.offer(root);
        }
        while (!que.isEmpty()) {
            int size = que.size();

            while (size > 0) {
                TreeNode tmpNode = que.poll();
                if (size == 1) {// 当取到每层的最后一个也就是最右侧才加入元素
                    al.add(tmpNode.val);
                }

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                size--;
            }

        }

        return al;
    }
}
