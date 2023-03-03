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

public class solution222 {
    public int countNodes(TreeNode root) {
        int count = 0;
        return preOrderCount(root, count);

    }

    int preOrderCount(TreeNode root, int count) {
        // 确定终止条件
        if (root == null) {
            return 1;
        }
        // 确定单层递归的逻辑

        int leftCount = preOrderCount(root.left, count); // 先对左侧都进行遍历
        int rightCount = preOrderCount(root.right, count); // 左侧走完走右侧
        return count = leftCount + rightCount;

    }
}
