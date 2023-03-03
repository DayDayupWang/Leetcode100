import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class solution17 {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        char[] dig = digits.toCharArray();
        HashMap<Character, String> phone = new HashMap<Character, String>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        ArrayList<String> zimuchuan = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            String SingleNumString = phone.get(digits.charAt(i));// 得到第i个数字字符到map中找到对应字符串
            zimuchuan = FCombinations(SingleNumString, zimuchuan, phone);
        }
    }

    public List<String> FCombinations(String SingleNumString, ArrayList<String> zimuchuan,
            HashMap<Character, String> phone) {
        if (zimuchuan == null) {
            for (int i = 0; i < SingleNumString.length(); i++) {
                zimuchuan.add(SingleNumString.charAt(i) + "");// 把初始字符装入
            }

        } else {
            for (int i = 0; i < SingleNumString.length(); i++) {
                zimuchuan.add(SingleNumString.charAt(i) + "");// 把后续字符装入
            }
        }
    }

}
