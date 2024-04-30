import java.util.Arrays;

public class 爬楼梯_70 {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        爬楼梯_70 solution = new 爬楼梯_70();
        System.out.println(solution.climbStairs(3));
    }
}