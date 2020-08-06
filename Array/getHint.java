package Array;

public class getHint {
    // Leetcode 299
    // 本题最重要的是注重hash 表得使用。
    // 所谓得hash表 最简单得形式就是有限个数，每个数字都有单独得index - 无conflict得形式。


    /**
     * Solution 1: 弱智暴力解法*/
    public String solution(String secret, String guess) {
        int[] g = new int[guess.length()];
        int[] s = new int[guess.length()];
        for (int i = 0; i < guess.length(); i ++) {
            char c = guess.charAt(i);
            char x = secret.charAt(i);
            g[i] = Character.getNumericValue(c);
            s[i] = Character.getNumericValue(x);
        }
        int bulls = 0;
        for (int i = 0; i < guess.length(); i ++) {
            if (s[i] == g[i]) {
                bulls += 1;
                s[i] = -1;
                g[i] = -1;
            }
        }
        int cows = 0;
        for (int i = 0; i < guess.length(); i ++) {
            if (s[i] >= 0) {
                for (int j = 0; j < guess.length(); j ++) {
                    if (g[j] == s[i]) {
                        cows += 1;
                        g[j] = -1;
                        s[i] = -1;
                        break;
                    }
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static String solutionIII(String secret, String guess) {
        int A = 0;
        int[] mapS = new int[10];
        int[] mapG = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                // 注意这里得使用。
                mapS[secret.charAt(i) - '0']++;
                mapG[guess.charAt(i) - '0']++;
            }
        }
        int B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(mapS[i], mapG[i]);
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(solutionIII(secret,guess));
        char test = '0';
        int tesss= test;
        System.out.println(tesss);
    }
}
