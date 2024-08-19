public class Q100327求出最长好子序列 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k+2][n];

        int[] max_line = new int[k+2];

        for(int i=1;i<=k+1;i++){
            dp[i][0] = 1;
            max_line[i] = 1;
        }//初始化

        for(int i=1;i<n;i++){
            dp[1][i] = 1;

            int same = -1;
            for(int j=i-1;j>=0;j--){
                if(nums[i] == nums[j]){
                    same = j;
                    break;
                }
            }

            if(same != -1){
                for(int j=1;j<=k+1;j++){
                    dp[j][i] = Math.max(dp[j][i],dp[j][same]+1);
                }
            }

            for(int j=2;j<=k+1;j++){
                // System.out.println("i:"+i);
                // System.out.println("j:"+j);
                // System.out.println(Arrays.toString(max_line));
                // System.out.println();
                dp[j][i] = Math.max(dp[j][i],max_line[j-1] + 1);
            }

            for(int j=1;j<=k+1;j++){
                max_line[j] = Math.max(max_line[j],dp[j][i]);
            }
        }

        int max = -1;
        for(int i=0;i<n;i++){
            max = Math.max(max,dp[k+1][i]);
        }

        // for(int i=0;i<=k+1;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        // System.out.println(Arrays.toString(max_line));
        return max;
    }

    public static void main(String[] args) {
        Q100327求出最长好子序列 solution = new Q100327求出最长好子序列();
        // System.out.println(solution.maximumLength(new int[]{1,2,1,1,3},2));
        // System.out.println(solution.maximumLength(new int[]{1,2,3,4,5,1},0));
        // System.out.println(solution.maximumLength(new int[]{1,14,1},3));
        // System.out.println(solution.maximumLength(new int[]{89,89,90,88,88,88,88,90,90},2));
        System.out.println(solution.maximumLength(new int[]{2,5},1));
    }
}