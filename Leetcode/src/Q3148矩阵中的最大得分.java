import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3148矩阵中的最大得分 {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();

        int ans = Integer.MIN_VALUE;

        int[][] dp = new int[n][m];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],Integer.MIN_VALUE);
        // }
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = grid.get(0).get(1) - grid.get(0).get(0);
        ans = Math.max(ans,dp[0][1]);
        dp[1][0] = grid.get(1).get(0) - grid.get(0).get(0);
        ans = Math.max(ans,dp[1][0]);


        for(int i=2;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0] + grid.get(i).get(0) - grid.get(i-1).get(0),grid.get(i).get(0) - grid.get(i-1).get(0));
            ans = Math.max(ans,dp[i][0]);
        }
        for(int i=2;i<m;i++){
            dp[0][i] = Math.max(dp[0][i-1] + grid.get(0).get(i) - grid.get(0).get(i-1),grid.get(0).get(i) - grid.get(0).get(i-1));
            ans = Math.max(ans,dp[0][i]);
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = Math.max(dp[i-1][j]+grid.get(i).get(j) - grid.get(i-1).get(j),dp[i][j-1]+grid.get(i).get(j) - grid.get(i).get(j-1));
                dp[i][j] = Math.max(dp[i][j],grid.get(i).get(j) - grid.get(i).get(j-1));
                dp[i][j] = Math.max(dp[i][j],grid.get(i).get(j) - grid.get(i-1).get(j));
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3148矩阵中的最大得分 solution = new Q3148矩阵中的最大得分();
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(6,5,1));
        grid.add(Arrays.asList(5,7,9));
        grid.add(Arrays.asList(6,7,4));
        grid.add(Arrays.asList(6,10,5));
        System.out.println(solution.maxScore(grid));

        System.out.println();
        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(2));
        System.out.println(Integer.bitCount(10));
        System.out.println(Integer.bitCount(100));
        System.out.println(Integer.bitCount(10000));
    }
}