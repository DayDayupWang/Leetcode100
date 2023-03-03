import java.util.ArrayList;
import java.util.List;

public class solution77 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmpList = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {

        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (tmpList.size() == k) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        // 可选择的元素范围会收缩，所以需要对选择的范围操作
        for (int i = startIndex; i <= n - (k - tmpList.size()) + 1; i++) {

            tmpList.add(i);

            backtracking(n, k, i + 1);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
