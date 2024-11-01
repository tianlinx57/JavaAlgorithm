package CodeForces;

import java.util.*;
 
public class Main {
    public long min_value (int[] nums, int m) {
        long ans = 0;
        long min = Long.MAX_VALUE;
        long max = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            if(i != 0){
                ans = ans+Math.abs(nums[i] - nums[i-1]);
            }
        }
        // if(min > m) ans = ans+
        if(min > 1) ans = ans+min-1;
        if(max < m) ans = ans+m-max;
        return ans;
    }
    public static void main(String[] args) {
        Main solution = new Main();
        System.out.println(solution.min_value(new int[]{5,1000000000,5,1000000000,5,1000000000},1000000010));
        System.out.println(Integer.valueOf("110"));
        System.out.println(Integer.parseInt("110",2));
    }
}
