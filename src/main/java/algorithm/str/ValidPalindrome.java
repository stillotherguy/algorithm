package algorithm.str;

public class ValidPalindrome {

    boolean del = false;

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (!del) {
                    del = true;

                    return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left + 1, right + 1));
                }

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("abcba"));
        System.out.println(new ValidPalindrome().validPalindrome("abcbba"));
    }
}
