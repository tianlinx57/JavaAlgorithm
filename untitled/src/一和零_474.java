public class 一和零_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<strs.length;i++){
            int sum_1 = sum_of_1(strs[i]);
            int sum_0 = sum_of_0(strs[i]);
            for(int j=m;j>=sum_0;j--){
                for (int k=n;k>=sum_1;k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j-sum_0][k-sum_1]+1);
                }
            }
            // for(int x=0;x<m+1;x++){
            //     System.out.println(Arrays.toString(dp[x]));
            // }
            // System.out.println();
        }
        int res = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                res = Math.max(res,dp[i][j]);
            }
        }

        return res;
    }

    int sum_of_1(String string){
        int sum=0;
        for(char c:string.toCharArray()){
            if(c == '1'){
                ++sum;
            }
        }
        return sum;
    }
    int sum_of_0(String string){
        int sum=0;
        for(char c:string.toCharArray()){
            if(c == '0'){
                ++sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        一和零_474 solution = new 一和零_474();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }
}