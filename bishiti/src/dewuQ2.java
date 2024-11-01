import java.util.Arrays;
import java.util.Scanner;

public class dewuQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = in.nextInt();
        }
        int[] dp = new int[n];
        int max = 0;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(a[i]-a[i-1] == b[i]-b[i-1]){
                dp[i] = dp[i-1]+1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
