import java.util.Arrays;

public class Q3040相同分数的最大操作数目II {
    int ans = 0;
    int[][] memo;
    int[] nums;
    public int maxOperations(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length][nums.length];
        int target1 = nums[0]+nums[1];
        ans = Math.max(ans,helper(2,nums.length-1,target1));

        int target2 = nums[0]+nums[nums.length-1];
        ans = Math.max(ans,helper(1,nums.length-2,target2));

        int target3 = nums[nums.length-1]+nums[nums.length-2];
        ans = Math.max(ans,helper(0,nums.length-3,target3));
        return ans;
    }

    int helper(int i,int j, int target){
        for(int[] array:memo){
            Arrays.fill(array,-1);
        }

        return dfs(i,j,target,1);
    }

    int dfs(int i,int j,int target,int depth){
        if(i>=nums.length || j<0 || j<=i){
            return depth;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int sum1 = nums[i]+nums[i+1];
        int sum2 = nums[i]+nums[j];
        int sum3 = nums[j]+nums[j-1];
        int res = 0;
        if(sum1 == target){
            res = Math.max(res,dfs(i+2,j,target,depth+1));
        }
        if(sum2 == target){
            res = Math.max(res,dfs(i+1,j-1,target,depth+1));
        }
        if(sum3 == target){
            res = Math.max(res,dfs(i,j-2,target,depth+1));
        }
        if(res == 0) {
            memo[i][j] = depth;
            return depth;
        }
        memo[i][j] = res;
        return res;

    }

    public static void main(String[] args) {
        Q3040相同分数的最大操作数目II solution = new Q3040相同分数的最大操作数目II();

        // System.out.println(solution.maxOperations(new int[]{3,2,1,2,3,4}));
        System.out.println(solution.maxOperations(new int[]{1,9,7,3,2,7,4,12,2,6}));
    }
}