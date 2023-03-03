import java.util.LinkedList;
import java.util.Queue;

public class solution104 {
    public static void main(String[] args) {

    }

    public int maxDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            depth += 1;
            while (size > 0) {
                TreeNode tmp = que.poll();

                if (tmp.left != null) {
                    que.add(tmp.left);
                }
                if (tmp.right != null) {
                    que.add(tmp.right);
                }
                size--;
            }
        }
        return depth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findMaxDepth(root);
    }

    public int findMaxDepth(TreeNode root) {
        if (root == null) {

            return 0;
        }

        int leftLength = findMaxDepth(root.left);
        int rightLength = findMaxDepth(root.right);
        int length = 1 + Math.max(leftLength, rightLength);
        return length;
    }
}
