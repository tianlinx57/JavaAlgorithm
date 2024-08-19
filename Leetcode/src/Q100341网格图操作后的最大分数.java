import java.util.Arrays;

public class Q100341网格图操作后的最大分数 {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] dp = new long[n+1][n];

        long sum0 = 0;
        for(int i=0;i<n;i++){
            sum0 += grid[i][1];
        }
        for(int i=0;i<=n;i++) {
            dp[i][1] = sum0;
            if(i!=n){
                sum0 += grid[i][0];
                sum0 -= grid[i][1];
            }
        }


        for(int i=2;i<n;i++) {
            for(int j=0;j<=n;j++) {
                int sum = 0;
                for(int k=0;k<=n;k++){
                    dp[j][i] = Math.max(dp[k][i - 1] + sum, dp[j][i]);
                    if (k != n && k>=j) {
                        sum += grid[k][i];
                    }
                }
            }
        }
        long max = 0;
        for(int i=0;i<=n;i++) {
            max = Math.max(max,dp[i][n-1]);
        }

        for(int i=0;i<=n;i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return max;
    }
    public static void main(String[] args) {
        Q100341网格图操作后的最大分数 solution = new Q100341网格图操作后的最大分数();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        // System.out.println(solution.minimumCost(3,2,new int[]{1,3},new int[]{5}));
        System.out.println(solution.maximumScore(new int[][]{{0,0,0,0,0},{0,0,3,0,0},{0,1,0,0,0},{5,0,0,4,0},{0,0,0,0,2}}));
    }
}