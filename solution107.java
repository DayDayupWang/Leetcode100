import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class solution107 {
    public static void main(String[] args) {
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        Stack<List<Integer>> x = new Stack<List<Integer>>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
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
            x.push(al);
        }
        while (!x.isEmpty()) {
            result.add(x.pop());
        }

        // 逆转的另一个方法
        // reverse(result.begin(), result.end()); // 在这里反转一下数组即可
        return result;
    }
}
