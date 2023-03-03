

public class solution344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            char tmp = s[left];

            s[left] = s[right];
            s[right] = tmp;
            right--;
            left++;
        }

    }
}
