import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution39 {
    private ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    private ArrayList<Integer> paths = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        comSum(candidates, target);

        return res;

    }

    private void comSum(int[] candidates, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(paths));

                return;
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (paths.contains(candidates[i])) {
                continue;
            }
            paths.add(candidates[i]);
            target -= candidates[i];
            comSum(Arrays.copyOfRange(candidates, i, candidates.length), target);
            target += candidates[i];
            paths.remove(paths.size() - 1);
        }
    }

}
