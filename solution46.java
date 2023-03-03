import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solution46 {
    private ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] used = new boolean[nums.length];
        backtracing(nums, used);
        return res;
    }

    private void backtracing(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 由于和前一个数相等而且没使用过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracing(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }

        }
    }

}
