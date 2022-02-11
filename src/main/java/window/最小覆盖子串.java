package window;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Ethan Zhang
 * @date 2022/2/11
 */
public class 最小覆盖子串 {

    public static void main(String[] args) {
        String s = "EBBANCF";
        String t = "ABC";

        System.out.println(minSubStr(s, t));
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
                if (window[c] == need[c])
                    valid++;
            }

            System.out.println(left + "  " + right + "  " + valid);

            while (valid == t.length()) {
                if (right - left < len) {
                    start = left;
                    len = right;

                    System.out.println(start + "  " + len);
                }

                final char l = s.charAt(left);
                if (need[l] > 0) {
                    if (window[l] == need[l])
                        valid--;

                    window[l]--;
                }

                left++;
            }

            right++;
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + 1);
    }
}
