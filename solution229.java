import java.util.ArrayList;

public class solution229 {
    public static void main(String[] args) {

    }

    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        int cand_num1 = nums[0];
        int cand_num2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cand_num1 == nums[i]) {
                count1++;
                continue;
            }
            if (cand_num2 == nums[i]) {
                count2++;
                continue;
            }
            // 第1个候选人配对
            if (count1 == 0) {
                cand_num1 = nums[i];
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand_num2 = nums[i];
                count2++;
                continue;
            }
            count1--;
            count2--;

        }
        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand_num1 == num)
                count1++;
            else if (cand_num2 == num)
                count2++;
        }

        if (count1 > nums.length / 3)
            res.add(cand_num1);
        if (count2 > nums.length / 3)
            res.add(cand_num2);

        return res;

    }
}
