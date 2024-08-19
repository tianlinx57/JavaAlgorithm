import java.util.Arrays;

public class Q3139使数组中所有元素相等的最小开销_正确 {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int mod = 1_000_000_007;
        int n = nums.length;

        //分两种情况讨论 cost2 >= cost1*2 直接全用cost1 不然就要dp
        if(cost1*2 <= cost2){
            long ans = 0;
            long max = Arrays.stream(nums).max().getAsInt();
            for(int i :nums){
                ans += (max-i)*cost1;
            }
            return (int)(ans%mod);
        }
        Arrays.sort(nums);//先排序

        if(nums.length==2){
            return (int) ((nums[1]-nums[0])*(long)cost1% mod);
        }

        long sum_1_to_n = 0;
        for(int i =1;i<n;i++){
            sum_1_to_n += nums[i];
        }

        long ans = Long.MAX_VALUE;

        long max = nums[n-1];//max为所有值都达到的最大值
        while(true){

            if(max*(n-1)-sum_1_to_n >= max-nums[0]-1){
                ans = Math.min(ans,(max*n - sum_1_to_n - nums[0])/2*(long)cost2 + (max*n - sum_1_to_n - nums[0])%2*(long)cost1);
                if(n%2 == 0 || (max*n - sum_1_to_n - nums[0])%2==0) break;
            } else {
                long temp = (max*(n-1)-sum_1_to_n)*(long)cost2 + (max-(max*(n-1)-sum_1_to_n)-nums[0])*(long)cost1;
                ans = Math.min(ans,temp);
            }
            max++;
        }
        System.out.println(ans);

        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        Q3139使数组中所有元素相等的最小开销_正确 solution = new Q3139使数组中所有元素相等的最小开销_正确();
        // System.out.println(solution.minCostToEqualizeArray(new int[]{2,3,3,3,5},2,1));
        // System.out.println(solution.minCostToEqualizeArray(new int[]{1000000,2,1,2,1000000},10000,4000));

        // System.out.println(solution.minCostToEqualizeArray(new int[]{4,1},5,2));
    }
}