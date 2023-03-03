public class solution144 {
    public static void main(String[] args) {
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        preOrder(root, result);
        return result;
    }

    void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);           // 注意这一句
        preOrder(root.left, result);
        preOrder(root.right, result);
    
    }
}
