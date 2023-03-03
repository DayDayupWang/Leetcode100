public class solution98 {
    private Long maxVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历，左中右顺序
        boolean left = isValidBST(root.left);
        if (maxVal < root.val) {
            // 存入中间值
            maxVal = (long) root.val;
        } else {
            // 不满足则立刻弹出
            return false;
        }
        boolean right = isValidBST(root.right);
        // 返回左右且的结果给父节点
        return left && right;
    }
}
