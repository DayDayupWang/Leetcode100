
import java.util.HashMap;
import java.util.Map;

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

public class solution105 {
    Map<Integer, Integer> map; // 方便根据数值查找位置

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, preorder, 0, preorder.length); // 前闭后开

    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] preorder, int preBegin, int preEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || preBegin >= preEnd) { // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        // 找到前序遍历的第一个元素在中序遍历中的位置
        // 也就是目前的一个父节点
        int rootIndex = map.get(preorder[preBegin]);

        TreeNode root = new TreeNode(inorder[rootIndex]); // 构造节点
        root.left = findNode(inorder, inBegin, rootIndex, // 中左
                preorder, preBegin + 1, preBegin + 1 + rootIndex - inBegin);// 前左
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                preorder, preBegin + 1 + rootIndex - inBegin, preEnd);

        return root;
    }

}
