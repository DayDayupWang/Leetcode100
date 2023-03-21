import java.util.ArrayDeque;

public class Nonrecursive_traversal_binary_tree {
    // 非递归先序遍历（需一个辅助栈，顺序为根——右——左）
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode tmpNode = stack.pollLast();

            System.out.println("tmpNode val :" + tmpNode.val);

            if (root.right != null) {
                stack.addLast(root.right);
            }
            if (root.left != null) {
                stack.addLast(root.left);
            }

        }

    }
}
