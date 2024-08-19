import java.util.ArrayList;
import java.util.List;


public class week33Q3得到目标数组的最少函数调用次数 {
    public int minOperations(int[] nums) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            ans += Integer.bitCount(num);
            max =  Math.max(max, num);
        }
        if(max!=0){
            ans += 31-Integer.numberOfLeadingZeros(max);
        }

        return ans;
    }
    public static void main(String[] args) {
        week33Q3得到目标数组的最少函数调用次数 solution = new week33Q3得到目标数组的最少函数调用次数();
        System.out.println(solution.minOperations(new int[]{1,5}));
        // System.out.println(Integer.numberOfLeadingZeros(5));
    }
}