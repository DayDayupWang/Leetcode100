import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class solution102_1 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) {
            que.offer(root);
        }
        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode tmpNode = que.poll();
                al.add(tmpNode.val);
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                size--;
            }
            res.add(al);

        }
        return res;
    }
}
