public class solution28 {
    public static void main(String[] args) {
        String hay = "mississippi";
        String needle = "issip";
        int res = strStr(hay, needle);
        System.out.println(res);
    }

    public static int strStr(String haystack, String needle) {
        int res = -1;
        char[] child = needle.toCharArray();
        char[] parent = haystack.toCharArray();
        int left = -1;
        while (left < parent.length) {
            left++;
            for (int i = 0; i < child.length; i++) {

                if (left + i < parent.length && parent[left + i] == child[i]) {
                    if (i == child.length - 1) {// 每一个字母都对上了
                        return left;
                    } else {
                        continue;
                    }
                } else {
                    // left = left + i;
                    break;
                }
            }
        }
        return res;
    }
}
