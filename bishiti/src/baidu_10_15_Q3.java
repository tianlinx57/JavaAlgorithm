import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class baidu_10_15_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if(n==1||n==2||n==3){
            System.out.println(0);
        }else{
            int[] nums = new int[n+1];
            baidu_10_15_Q3 solution = new baidu_10_15_Q3();
            solution.dfs(1,nums,14);
            System.out.println(solution.res);
        }
    }
    // HashSet<Long> hashSet = new HashSet<>();
    int res=0;
    void dfs(int start,int[] nums,int left){
        if(left==0){
            // System.out.println(Arrays.toString(nums));
            if(test(nums)){
                // System.out.println(Arrays.toString(nums));
                ++res;
            }
            return;
        }
        if(start>nums.length-1) return;
        for(int i=0;i<=4&&i<=left;++i){
            nums[start]=i;
            dfs(start+1,nums,left-i);
            nums[start]=0;
        }
    }
    boolean test(int[] nums){
        // long key = nums[0];
        // for(int i=1;i<nums.length;++i){
        //     key = key*10+nums[i];
        // }
        // if(hashSet.contains(key)) return false;
        // hashSet.add(key);
        // System.out.println(Arrays.toString(nums));
        // System.out.println(test_dfs(0,nums,false));
        // System.out.println();
        return test_dfs(0,nums,false);
    }
    boolean test_dfs(int sum,int[] nums,boolean have2){
        if(sum == 14) return true;
        int first = 1;
        while (nums[first]==0) {
            ++first;
            if(first >= nums.length) return false;
        }
        if(nums[first]>=2 && !have2){
            nums[first] -= 2;
            if(test_dfs(sum+2,nums,true)) {
                nums[first] += 2;
                return true;
            }
            nums[first] += 2;
        }
        if(nums[first]>=3){
            nums[first] -= 3;
            if(test_dfs(sum+3,nums,have2)) {
                nums[first] += 3;
                return true;
            }
            nums[first] += 3;
        }
        if(first<=nums.length-3 && nums[first+1]>=1 && nums[first+2]>=1){
            nums[first] -= 1;
            nums[first+1] -= 1;
            nums[first+2] -= 1;
            if(test_dfs(sum+3,nums,have2)) {
                nums[first] += 1;
                nums[first+1] += 1;
                nums[first+2] += 1;
                return true;
            }
            nums[first] += 1;
            nums[first+1] += 1;
            nums[first+2] += 1;
        }
        return false;
    }

}
