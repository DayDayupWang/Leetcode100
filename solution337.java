public class solution337 {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);

    }

    // 状态标记法
    private int[] robTree(TreeNode root) {
        int[] res = new int[2];

        if (root == null) {
            return res;
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        // 不偷节点则考虑偷左右孩子
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷节点则左右孩子不偷
        res[1] = root.val + left[0] + right[0];
    }
}
