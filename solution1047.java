import java.util.Deque;
import java.util.Stack;

public class solution1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates2(s));
    }

    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {

            if (!stack.isEmpty() && stack.peek() == charArray[i]) {
                System.out.println(stack.peek());
                System.out.println(charArray[i]);
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static String removeDuplicates2(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }
}
