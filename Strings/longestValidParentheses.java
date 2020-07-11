package Strings;

public class longestValidParentheses {
    // Leetcode 32
    public static int solution(String s) {
        boolean right = false;
        int length = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i ++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                if (right) {
                    length = 0;
                }
                right = true;
            } else {
                if (right) {
                    length += 2;
                    right = false;
                    if (length > longest)
                        longest = length;
                } else {
                    // Expected ( but given )
                    length = 0;
                    right = true;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String test = "(()())";
        System.out.println(solution(test));
    }
}
