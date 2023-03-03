import java.util.HashSet;

/**
 * solution202
 */
public class solution202 {

    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        if (n == 1 || n == 7) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        // 分离n的各个位存入set进行
        HashSet<Integer> Set = new HashSet<>();
        int gewei = 0;
        while (n > 0) {
            gewei = n / 10;
            if (Set.contains(gewei)) {
                return false;
            }
            Set.add(gewei);
            n = n / 10;
        }
        int sum = 0;
        for (Integer integer : Set) {
            sum = sum + integer * integer;
        }

        return isHappy(sum);
    }
}