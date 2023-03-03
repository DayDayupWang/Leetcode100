import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution1002 {
    public static void main(String[] args) {
        // System.out.println(3%1);
        String[] words = new String[] { "bella", "label", "roller" };
        List<String> kk = commonChars(words);
        System.out.println(kk);
    }

    public static List<String> commonChars(String[] words) {
        if (words == null) {
            return null;
        }

        int[] record = new int[26];
        int[] tmp = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                record[c - 'a'] += 1;// 在相应位置+1
            }
            if (i == 0) {
                tmp = record;
            }
            if (i >= 1) {
                for (int j = 0; j < tmp.length; j++) {
// tmp[]
                }
            }
        }
        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < record.length; i++) {

            if (record[i] != 0 && (record[i] % words.length == 0)) {// 假如表中字母出现的次数为字符串数组长度的整数倍
                int num = record[i];
                while (num > 0) {
                    Character q = (char) ('a' + i);
                    res.add(q.toString());// 则添加到结果集
                    num = num - words.length;
                }

            }
        }
        return res;
    }

    public void resadd(ArrayList<String> res, int chuxiancishu, int len) {

    }
}
