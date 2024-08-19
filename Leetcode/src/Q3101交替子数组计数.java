//给你一个数组 nums ，它是 [0, 1, 2, ..., n - 1] 的一个
// 排列
//  。对于任意一个 [0, 1, 2, ..., n - 1] 的排列 perm ，其 分数 定义为：
//
// score(perm) = |perm[0] - nums[perm[1]]| + |perm[1] - nums[perm[2]]| + ... + |perm[n - 1] - nums[perm[0]]|
//
// 返回具有 最低 分数的排列 perm 。如果存在多个满足题意且分数相等的排列，则返回其中
// 字典序最小
// 的一个。
public class Q3101交替子数组计数 {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        long ans=1;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i] != nums[i-1]){
                dp[i] = dp[i-1]+1;
            } else {
                dp[i] = 1;
            }
            ans += dp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3101交替子数组计数 solution = new Q3101交替子数组计数();
        // System.out.println(solution.countAlternatingSubarrays(new int[]{0,1,1,1}));
        int a = 10;
        a>>=1;
        System.out.println(a);

    }
}