// 注意类名必须为 Main, 不要有任何 package xxx 信息
// 回溯超时 要用动态规划
public class Q3129找出所有稳定的二进制数组I_动态规划 {
    public static void main(String[] args) {
        Q3129找出所有稳定的二进制数组I_动态规划 main = new Q3129找出所有稳定的二进制数组I_动态规划();
        // System.out.println(main.numberOfStableArrays(20,15,75));
        System.out.println(main.numberOfStableArrays(39,20,18));

        // System.out.println(3247943160L % (Math.pow(10,9)+7));
        // System.out.println((int) (3247943160L % (Math.pow(10,9)+7)));
    }


    public int numberOfStableArrays(int zero, int one, int limit) {
        final int chushu = 1_000_000_007;
        int[][][] dp = new int[zero+1][one+1][2];

        for(int i=1;i <= Math.min(limit, zero);i++){
            dp[i][0][0] = 1;
        }

        for(int i=1;i <= Math.min(limit, one);i++){
            dp[0][i][1] = 1;
        }

        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                int temp1 =0,temp2=0;
                if(i>=limit+1) temp1 = dp[i-limit-1][j][1];
                if(j>=limit+1) temp2 = dp[i][j-limit-1][0];
                // dp[i][j][0] = (int) ((dp[i-1][j][0] + dp[i-1][j][1] - temp1) % chushu);
                // dp[i][j][1] = (int) ((dp[i][j-1][0] + dp[i][j-1][1] - temp2)%chushu);
                dp[i][j][0] = (int) (((long)dp[i-1][j][0] + dp[i-1][j][1] + chushu - temp1)%chushu);

                // dp[i][j][0] = (int) (((long) dp[i - 1][j][0] + dp[i - 1][j][1] + (i > limit ? chushu - dp[i - limit - 1][j][1] : 0)) % chushu);


                dp[i][j][1] = (int) (((long)dp[i][j-1][0] + dp[i][j-1][1] + chushu - temp2)%chushu);
                System.out.println(dp[i][j][0]);
                System.out.println(dp[i][j][1]);
                System.out.println();
            }
        }
        // System.out.println(dp[zero][one][0]);
        // System.out.println(dp[zero][one][1]);
        // System.out.println((int) (((long)dp[zero][one][0]+dp[zero][one][1])%chushu));

        return (int) (((long)dp[zero][one][0]+dp[zero][one][1])%chushu);
    }

}