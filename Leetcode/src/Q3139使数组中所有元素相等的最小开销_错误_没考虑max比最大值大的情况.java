import java.util.Arrays;

public class Q3139使数组中所有元素相等的最小开销_错误_没考虑max比最大值大的情况 {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int mod = 1_000_000_007;
        int n = nums.length;

        //分两种情况讨论 cost2 >= cost1*2 直接全用cost1 不然就要dp
        if(cost1*2 <= cost2){
            long ans = 0;
            int max = Arrays.stream(nums).max().getAsInt();
            for(int i :nums){
                ans += (max-i)*cost1;
            }
            return (int)(ans%mod);
        }
        Arrays.sort(nums);//先排序

        if(nums.length==2){
            return (nums[1]-nums[0])*cost1;
        }

        long ans = 0;
        int ji_ou = 0;//判断奇偶情况
        boolean done = false;
        long[] dp = new long[n];

        dp[0] = 0;
        dp[1] = 0;


        for(int i=2;i<n;i++){
            if(nums[i] == nums[i-1]) continue;
            if(!done){
                if((nums[i]-nums[i-1])*(i-1) >= nums[i]-nums[0]-1){
                    done = true;
                    int sum =0;
                    for(int j=0;j<i;j++){
                        sum += nums[i] - nums[j];
                        nums[j] = nums[i];
                    }
                    // System.out.println(sum);
                    if(sum%2 == 1) {
                        ji_ou = 1;
                        nums[0] = nums[i]-1;
                    } else {
                        ji_ou = 0;
                        nums[0] = nums[i];
                    }
                    // System.out.println(Arrays.toString(nums));
                    // System.out.println((sum/2)*cost2);
                    dp[i] = dp[i-1] + (sum/2)*cost2;
                }else{
                    int sum = (nums[i]-nums[i-1])*(i-1);
                    nums[0] += sum;
                    for(int j=1;j<i;j++){
                        nums[j] = nums[i];
                    }
                    dp[i] = dp[i-1] + sum*cost2;
                }
            }else{
                if(ji_ou == 0){
                    long gap = (nums[i]-nums[i-1])*i;
                    if(gap%2==0){
                        ji_ou=0;
                    } else {
                        ji_ou=1;
                    }
                    dp[i] = dp[i-1] + gap/2*cost2;
                } else{
                    long gap = (nums[i]-nums[i-1])*i;
                    if(gap%2==0){
                        ji_ou=1;
                        dp[i] = dp[i-1] + gap/2*cost2;
                    } else {
                        ji_ou=0;
                        dp[i] = dp[i-1] + (gap+1)/2*cost2;
                    }
                }
            }
        }
        if(!done){
            dp[n-1] += (nums[n-1]-nums[0])*cost1;
        } else if (ji_ou == 1) {
            dp[n-1] += cost1;
        }

        System.out.println(Arrays.toString(dp));

        return (int) (dp[n-1] % mod);

    }

    public static void main(String[] args) {
        Q3139使数组中所有元素相等的最小开销_错误_没考虑max比最大值大的情况 solution = new Q3139使数组中所有元素相等的最小开销_错误_没考虑max比最大值大的情况();
        // System.out.println(solution.minCostToEqualizeArray(new int[]{2,3,3,3,5},2,1));
        System.out.println(solution.minCostToEqualizeArray(new int[]{4,1},5,2));
    }
}