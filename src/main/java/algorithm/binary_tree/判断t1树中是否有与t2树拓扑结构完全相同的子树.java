package algorithm.binary_tree;

import algorithm.utils.TreeNode;

/**
 * @author Ethan Zhang
 * @date 2022/5/3
 */
public class 判断t1树中是否有与t2树拓扑结构完全相同的子树 {

    public static boolean contains(TreeNode t1, TreeNode t2) {
        String str1 = serializeByPre(t1);
        String str2 = serializeByPre(t2);

        return kmp(str1, str2) != -1;
    }

    private static int kmp(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()) {
            return -1;
        }

        int s1 = 0;
        int s2 = 0;
        char[] ss = str1.toCharArray();
        char[] tt = str2.toCharArray();
        int[] next = getNextArray(ss);
        while (s1 < ss.length && s2 < tt.length) {
            if (ss[s1] == tt[s2]) {
                s1++;
                s2++;
            } else if (next[s2] == -1) {
                // 第一位就不想等的情况
                s1++;
            } else {
                s2 = next[s2];
            }
        }

        return s2 == tt.length ? s2 - s1 : -1;
    }

    private static int[] getNextArray(char[] ss) {
        if (ss.length == 1) {
            return new int[]{-1};
        }

        int[] res = new int[ss.length];
        res[0] = -1;
        res[1] = 0;

        int cnt = 0;
        int pos = 2;
        while (pos < ss.length) {
            if (ss[cnt] == ss[pos]) {
                res[pos++] = ++cnt;
                // TODO
            } else if (cnt > 0) {
                // 不想等但是有共同前缀，退到相同前缀部分的下一位继续比较，如果一直都不匹配，最终会退到cnt=0
                cnt = res[cnt];
            } else {
                res[pos++] = 0;
            }
        }

        return new int[0];
    }

    private static String serializeByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }

        String res = head.value + "!";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);

        return res;
    }
}
