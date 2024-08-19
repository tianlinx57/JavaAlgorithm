import java.util.Arrays;

class SimilarHuiwen {

    // 构建一个二维数组，用于动态规划的状态存储
    long[][] dp;

    long jinsiHuiwenShuliang(int n) {
        // 初始化动态规划数组
        dp = new long[2][n + 1];

        // 初始状态
        dp[0][1] = 26;
        dp[1][1] = 0;
        dp[0][2] = 26;
        dp[1][2] = 26*26-26;

        // 根据状态转移方程进行动态规划求解
        for (int i = 1; i < n-1 ; i++) {
            dp[0][i + 2] = (dp[0][i] * 26) % 998244353;
            dp[1][i + 2] = (dp[1][i] * 26 + dp[0][i] * 25 * 26) % 998244353;
        }
        System.out.println(Arrays.deepToString(dp));

        // 返回结果，最后一个元素即为结果
        return dp[1][n];
    }

    public static void main(String[] args) {
        SimilarHuiwen similarHuiwen = new SimilarHuiwen();
        int n = 2022; // 定义字符串长度为2
        long result = similarHuiwen.jinsiHuiwenShuliang(n);
        System.out.println("近似回文串数量为：" + result);
    }
}
