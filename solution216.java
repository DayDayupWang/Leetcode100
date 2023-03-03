import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class solution216 {
    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 从1开始相加数字
        backTracking(k, n, 1);
        return lists;
    }

    public void backTracking(int k, int n, int index) {
        if (sum == n && k == 0) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; k > 0 && i < 10 && i + sum <= n; i++) {

            sum += i;
            deque.push(i);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(k - 1, n, i + 1);
            sum -= deque.pop();

        }
    }

}
