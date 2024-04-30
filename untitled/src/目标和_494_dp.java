public class 目标和_494_dp {

    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if((sum+target)%2 == 1) return 0;
        if(Math.abs(target) > sum) return 0;
        int real_target = (sum+target)/2;

        int[] dp = new int[real_target+1];
        dp[0] = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=real_target;j>=nums[i];j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[real_target];
    }

    public static void main(String[] args) {
        目标和_494_dp solution = new 目标和_494_dp();
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1},5));
    }
}