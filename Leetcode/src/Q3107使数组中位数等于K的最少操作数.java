import java.util.Arrays;

public class Q3107使数组中位数等于K的最少操作数 {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid_value = n%2==1 ? nums[n/2-1] : (nums[n/2]+nums[n/2-1])/2;

        if(mid_value==k) return 0;
        long ans = 0;
        if(mid_value>k){
            for(int i=0;i<=n/2;i++){
                if(nums[i] > k){
                    ans += nums[i] - k;
                }
            }
        }else{
            for(int i=n-1;i>=(n-1)/2;i--){
                if(nums[i] < k){
                    ans += k - nums[i];
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Q3107使数组中位数等于K的最少操作数 solution = new Q3107使数组中位数等于K的最少操作数();
        System.out.println(solution.minOperationsToMakeMedianK(new int[]{2,5,6,8,5},4));


    }
}