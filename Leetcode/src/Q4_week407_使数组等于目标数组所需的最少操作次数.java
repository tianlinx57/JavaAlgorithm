import java.util.Arrays;

public class Q4_week407_使数组等于目标数组所需的最少操作次数 {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            nums[i] -= target[i];
        }
        int flag = 1;
        int last = 0;
        for(int i:nums) {
            if(i<0 && flag==1) {
                flag = -1;
                ans += Math.abs(i); 
                last = Math.abs(i);
                continue;
            }
            if(i>0 && flag==-1) {
                flag = 1;
                ans += i;
                last = i;
                continue;
            }
            int temp = Math.abs(i);
            if(temp > last){
                ans += temp-last;
            }
            last = temp;

        }
        return ans;
    }
    public static void main(String[] args) {
        Q4_week407_使数组等于目标数组所需的最少操作次数 solution = new Q4_week407_使数组等于目标数组所需的最少操作次数();
        System.out.println(solution.minimumOperations(new int[]{3,5,1,2},new int[]{4,6,2,4}));
    }
}