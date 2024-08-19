// 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
//
// perm[i] 能够被 i 整除
// i 能够被 perm[i] 整除
// 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。

public class Q526优美的排列 {
    public int countArrangement(int n) {
        int mask = 1<<n;
        int[][] dp = new int[n+1][mask];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<mask;j++){
                if(Integer.bitCount(j)!=i) continue;
                for(int k=1;k<=n;k++){
                    if(k%i != 0 && i%k != 0){
                        continue;
                    }
                    if((j>>(k-1)&1) == 0){
                        continue;
                    }
                    dp[i][j] += dp[i-1][j & (~(1<<(k-1)))];
                }
            }
        }

        // for(int i=0;i<=n;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return dp[n][mask-1];
    }

    public static void main(String[] args) {
        Q526优美的排列 solution = new Q526优美的排列();
        System.out.println(solution.countArrangement(2)); // 2
    }
}