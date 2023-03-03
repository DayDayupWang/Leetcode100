public class solution151 {
    public static void main(String[] args) {
        String s = "a g";
        String space = " ";
        // System.out.println(space);
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        String trim = s.trim();
        ;// 摘掉前后空格
        char[] charArray = trim.toCharArray();
        StringBuilder res = new StringBuilder();
        // StringBuilder tmp = new StringBuilder();

        int left = charArray.length - 1;
        int right = left;
        while (left >= 0) {

            while (left != -1 && charArray[left] != ' ' && charArray[right] != ' ') {
                left--;// 先左指针一直移动到空格位置
            }
            // 此时左侧到了单词前第一个空格
            for (int i = left + 1; i <= right; i++) {
                res.append(charArray[i]);
            }
            if (left != -1) {
                res.append(' ');// 此时加入了最后的单词和空格

                while (charArray[left] == ' ') {
                    left--;// 左指针一直移动到字母位置
                }
                // 此时左侧到了单词最后一位
                right = left;
            }

        }

        return res.toString();
    }
}
// if (charArray[i] == ' ') {
// res.append('%');
// res.append('2');
// res.append('0');
// } else {
// res.append(charArray[i]);
// }