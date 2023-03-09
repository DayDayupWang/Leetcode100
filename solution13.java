import java.util.HashMap;

public class solution13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char charAt1 = s.charAt(i);
            char charAt2 = s.charAt(i + 1);
            if (charAt1 == 'M' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 1000;
            }
            if (charAt1 == 'D' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 500;
            }
            if (charAt1 == 'C' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 100;
            }
            if (charAt1 == 'C' && map.get(charAt1) < map.get(charAt2)) {
                sum -= 100;
            }
            if (charAt1 == 'L' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 50;
            }
            if (charAt1 == 'X' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 10;
            }
            if (charAt1 == 'X' && map.get(charAt1) < map.get(charAt2)) {
                sum -= 10;
            }
            if (charAt1 == 'V' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 5;
            }
            if (charAt1 == 'I' && map.get(charAt1) >= map.get(charAt2)) {
                sum += 1;
            }
            if (charAt1 == 'I' && map.get(charAt1) < map.get(charAt2)) {
                sum -= 1;
            }
        }
        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }

    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
