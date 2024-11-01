import java.util.Arrays;
import java.util.Scanner;

public class xiechengQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        xiechengQ3 x = new xiechengQ3();
        System.out.println(x.dfs(nums,0,m));
    }
    int[][] memo;
    int dfs(int[] nums, int start, int m){
        if(start==0){
            memo = new int[nums.length][m+1];
        }
        if(memo[start][m]!=0){
            return memo[start][m];
        }
        // System.out.println(start);
        // System.out.println(m);
        // System.out.println();
        if(m == 1){
            int gcd = nums[start];
            for(int i=start+1;i<=nums.length-1;++i){
                gcd = gcd(gcd, nums[i]);
            }
            return gcd;
        }
        
        if(m==nums.length-m-1){
            return nums[start]+dfs(nums, start+1, m-1);
        }
        int max = Integer.MIN_VALUE;
        int gcd = nums[start];
        for(int i=start;i<=nums.length-m && i<=nums.length-1;++i){
            gcd = gcd(gcd, nums[i]);
            max = Math.max(max, gcd + dfs(nums, i+1, m-1));
        }
        memo[start][m] = max;
        return max;
    }
    static int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
}
