public class 连续子数组个数 {
    public int subarraynumber(int[] nums,int k){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1]+nums[i-1];
        }
        int ans = 0;
        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                if(dp[j]-dp[i] == k) ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        连续子数组个数 solution = new 连续子数组个数();
        System.out.println(solution.subarraynumber(new int[]{1,1,1},2));
    }
}