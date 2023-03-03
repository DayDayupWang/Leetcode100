import java.util.ArrayList;
import java.util.List;

public class solution113 {
    private List<Integer> paths = new ArrayList<>();
    private ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        paths.add(root.val);
        findPath(root, targetSum - root.val);
        return res;
    }

    private void findPath(TreeNode root, int count) {
        if (root.left == null && root.right == null && count == 0) {
            res.add(new ArrayList<>(paths));
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            paths.add(root.left.val);
            findPath(root.left, count - root.left.val);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            paths.add(root.right.val);
            findPath(root.right, count - root.right.val);
            paths.remove(paths.size() - 1);
        }

    }

}
