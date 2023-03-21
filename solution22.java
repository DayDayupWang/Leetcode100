import java.util.ArrayList;
import java.util.List;

public class solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
    }

    private void dfs(String string, int left, int right, List<String> res) {

        if (left == 0 && right == 0) {
            res.add(string);
        }
        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(string + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(string + ")", left, right - 1, res);
        }
    }
}
