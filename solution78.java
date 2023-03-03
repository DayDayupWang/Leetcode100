import java.util.ArrayList;
import java.util.List;

public class solution78 {
    ArrayList<Integer> paths = new ArrayList<Integer>();
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int startIndex = 0;
        findSubSet(nums, startIndex);
        return res;
    }

    private void findSubSet(int[] nums, int startIndex) {
        res.add(new ArrayList<>(paths));
        // 终止条件可不加
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            paths.add(nums[i]);
            findSubSet(nums, i + 1);
            paths.remove(paths.size() - 1);
        }
    }

}
