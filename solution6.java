import java.util.ArrayList;
import java.util.List;

/**
 * solution6
 */
public class solution6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuffer> rows = new ArrayList<StringBuffer>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuffer());
        }
        // 定位rows中的StringBuffer
        int i = 0;
        // 决定方向
        int flag = -1;
        for (char c : s.toCharArray()) {

            rows.get(i).append(c);
            // 假如碰壁则反向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer row : rows) {
            res.append(row);
          
        }
        return res.toString();
    }

}