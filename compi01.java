public class compi01 {
    public static void main(String[] args) {

    }

    public int[] evenOddBit(int n) {
        int[] bit = new int[2];
        int flag = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                if (flag % 2 == 0) {
                    bit[0] += 1;
                }
                if (flag % 2 == 1) {
                    bit[1] += 1;
                }

            }
            flag++;
            n = n >> 1;
        }
        return bit;
    }
}
