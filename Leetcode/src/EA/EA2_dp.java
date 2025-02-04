package EA;

public class EA2_dp {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;

        // 所有长度为1的子串都是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 填充dp数组
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true; // 两个字符且相同
                    } else {
                        dp[i][j] = dp[i + 1][j - 1]; // 取决于内部子串
                    }
                } else {
                    dp[i][j] = false;
                }

                // 更新最长回文子串
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }


}
