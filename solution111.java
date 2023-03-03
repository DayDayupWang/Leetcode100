
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

public class solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findMinDepth(root);

    }

    public int findMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = findMinDepth(root.left);
        int rightDepth = findMinDepth(root.right);

        if (root.left == null || root.right == null) {// 因为其中一个为0
            return leftDepth + rightDepth + 1;
        }
        // 都不为空
        return Math.min(leftDepth, rightDepth) + 1;
    }

}
