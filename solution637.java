import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class solution637 {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Double> result = new ArrayList<Double>();
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
            Double sum = 0.0;
            for (int i = 0; i < al.size(); i++) {
                sum = sum + al.get(i).doubleValue();
            }

            result.add(sum / al.size());
        }

        return result;
    }
}
