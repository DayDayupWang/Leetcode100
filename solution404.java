public class solution404 {
    public int sumOfLeftLeaves(TreeNode root) {

        return countAllLeft(root);
    }

    private int countAllLeft(TreeNode root) {
        if (root == null) {
            // 最底层或者叶子点层还只有0
            return 0;
        }
        // 如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子
        // 递归的遍历顺序为后序遍历（左右中）是因为要通过递归函数的返回值来累加求取左叶子数值之和。
        int left = countAllLeft(root.left);
        int right = countAllLeft(root.right);
        int mid = 0;
        // 返回值实在倒数第二层开始大于0的，是把叶子点条件判断好后得到的

        if (root.left != null && root.left.right == null && root.left.left == null) {
            mid = root.left.val;
        }
        return left + right + mid;
    }

}
