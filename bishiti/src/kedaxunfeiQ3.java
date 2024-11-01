import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class kedaxunfeiQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            System.out.print(dfs(nums, i, i, nums[i]));
            System.out.print(" ");
        }
    }
    static long dfs(int[] nums, int start, int end, int sum){
        long ans=sum; 
        if(start!=0){
            if(nums[start-1]>sum){
                ans = Math.max(ans,dfs(nums, start-1, end, sum+nums[start-1]));
            }
        }
        if(end!=nums.length-1){
            if(nums[end+1]>sum){
                ans = Math.max(ans,dfs(nums, start, end+1, sum+nums[end+1]));
            }
        }
        return ans;
    }
    
}
