import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class solution112 {

    public static void main(String[] args) {
        TreeNode foo = new TreeNode(1);
        foo.left = new TreeNode(-2);
        foo.right = new TreeNode(3);
        System.out.println(hasPathSum(foo, -1));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return PathSum(root, targetSum - root.val);

    }

    private static boolean PathSum(TreeNode root, int count) {
        // 遇到叶子节点，并且计数为0
        if (root.left == null && root.right == null && count == 0) {
            return true;
        }
        // 遇到叶子节点而技术不为0
        if (root.left == null && root.right == null) {
            return false;
        }
        if (root.left != null) {
            count -= root.left.val;
            if (PathSum(root.left, count)) {
                return true;
            }
            count += root.left.val;
        }
        if (root.right != null) {
            count -= root.right.val;
            if (PathSum(root.right, count)) {
                return true;
            }
            count += root.right.val;
        }
        return false;
    }
}
// Queue<TreeNode> que = new LinkedList<>();
// que.add(root);
// while (!que.isEmpty()) {
// int size = que.size();
// while (size > 0) {
// TreeNode tmpNode = que.poll();

// size--;
// }
// }