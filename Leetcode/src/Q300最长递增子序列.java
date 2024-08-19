import java.util.Arrays;
import java.util.Scanner;

public class Q300最长递增子序列 {

    /*
     * Complete the function below.
     */


    // static int findLIS(int[] s) {
    //     int[] dp = new int[s.length];
    //     for(int i = 0; i<s.length; i++){
    //         dp[i] = 1;
    //     }
    //     for(int i = 1; i<s.length; i++){
    //         for(int j = 0;j<i;j++){
    //             if(s[i] > s[j] && dp[i] < dp[j]+1){
    //                 dp[i] = dp[j]+1;
    //             }
    //         }
    //     }
    //     int res = 0;
    //     for(int i = 0; i<s.length; i++){
    //         if(dp[i] > res){
    //             res = dp[i];
    //         }
    //     }
    //     // System.out.println(Arrays.toString(dp));
    //     return res;
    // }
    static int[] findLIS(int[] s) {
        int[][] dp = new int[s.length+1][s.length];
        for(int i = 0; i<s.length+1; i++){
            for(int j = 0;j<s.length;j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 1; i<s.length; i++){
            for(int j = 0;j<i;j++){
                if(s[i] > s[j] && dp[0][i] < dp[0][j]+1){
                    dp[0][i] = dp[0][j]+1;
                    dp[dp[0][j]][i] = s[j];
                    // System.out.println(dp[0][j]);
                }
            }
        }
        int max = 0,index = 0;
        for(int i = 0; i<s.length; i++){
            if(dp[0][i] > max){
                max = dp[0][i];
                index = i;
            }
        }
        // System.out.println(max);
        // System.out.println(index);
        int[] res = new int[max];
        for(int i =1;i<=max-1;i++){
            res[i-1] = dp[i][index];
        }
        res[max-1] = s[index];
        // for(int i = 0; i<s.length+1; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _s_size = Integer.parseInt(in.nextLine());
        int[] _s = new int[_s_size];
        int _s_item;
        for(int _s_i = 0; _s_i < _s_size; _s_i++) {
            _s_item = Integer.parseInt(in.nextLine());
            _s[_s_i] = _s_item;
        }

        res = findLIS(_s);
        System.out.println(Arrays.toString(res));

    }
}