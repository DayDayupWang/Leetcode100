public class solution150 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        // 遇到数字压入数字栈
        // 遇到算符压入算符栈
        // 只要遇到算符就拿出两个数字一个放左一个放右运算，
        // 结果放回数字栈
        int[] res = new int[tokens.length];
        int hh = 0, tt = -1;
        for (int i = 0; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) {// 假如是操作符
                // 右操作数是出栈的第一位，左操作数是出栈的第二位
                int b = res[tt--], a = res[tt--];
                // 使得现在的栈顶为当前的结果,++tt相当于回到了a的位置
                res[++tt] = calc(a, b, tokens[i]);
            } else {
                //包括初始化，把字符串数字转为了数字
                res[++tt] = Integer.parseInt(tokens[i]);
            }
        }
        return res[tt];
    }

    int calc(int a, int b, String op) {
        if (op.equals("+"))
            return a + b;
        else if (op.equals("-"))
            return a - b;
        else if (op.equals("*"))
            return a * b;
        else if (op.equals("/"))
            return a / b;
        else
            return -1;
    }

}
