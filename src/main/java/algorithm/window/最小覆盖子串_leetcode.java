package algorithm.window;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author Ethan Zhang
 * @date 2022/2/11
 */
public class 最小覆盖子串_leetcode {

    public static void main(String[] args) {
//        String s = "bbaa";
//        String t = "aba";

        // String s = "aa";
        // String t = "aa";
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        // baa
        System.out.println(NumberFormat.getInstance(Locale.KOREA).format(new BigDecimal("10000000.123")));
    }

    public static String minSubStr(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int[] window = new int[128];
        while (right < s.length()) {
            final char c = s.charAt(right);
            if (need[c] > 0) {
                window[c]++;

                if (window[c] <= need[c])
                    valid++;
            }

            System.out.println(left + "  " + right + "  " + valid);

            right++;

            while (valid == t.length()) {
                if (right - left < len) {
                    start = left;
                    // 注意right已经自动+1，所以这里无需+1
                    len = right - left;

                    System.out.println(start + "  " + len);
                }

                final char l = s.charAt(left);
                if (need[l] > 0) {
                    // 可能有多个重复char被算进去，所以有这一步
                    if (window[l] <= need[l])
                        valid--;

                    window[l]--;
                }

                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }
}
