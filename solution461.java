public class solution461 {
    public static void main(String[] args) {
        int x=4;
        int y=1;
      int count=  hammingDistance(x,y);
      System.out.println(count);
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            if (x % 2 == y % 2) {

            } else {
                count++;
            }
            x = x / 2;
            y = y / 2;
        }
        return count;
    }
}
