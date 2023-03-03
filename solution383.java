public class solution383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] charArray = magazine.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            arr[charArray[i] - 'a'] += 1;
        }
        char[] charArray2 = ransomNote.toCharArray();
        for (int i = 0; i < charArray2.length; i++) {
            arr[charArray2[i] - 'a'] -= 1;
            if (arr[charArray2[i] - 'a'] <0) {
                return false;
            }
        }
        return true;
    }
}
