import java.util.Arrays;

public class 分割等和子集_416_dp {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int target = sum/2;

        int[][] dp = new int[nums.length][target+1];
        for(int i = nums[0];i<=target;i++){
            dp[0][i] = nums[0];
        }

        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=target;j++){
                dp[i][j] = Math.max(dp[i-1][j],j-nums[i]>=0 ? dp[i-1][j-nums[i]]+nums[i]:0);
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[nums.length-1][target] == target;
    }

    public static void main(String[] args) {
        分割等和子集_416_dp solution = new 分割等和子集_416_dp();
        System.out.println(solution.canPartition(new int[]{1,2,5}));
    }
}