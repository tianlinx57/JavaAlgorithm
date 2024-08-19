import java.util.Arrays;
import java.util.Scanner;

public class 小美和小团_矩阵相聚 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int mod = 1_000_000_007;
        int n = in.nextInt();
        int m = in.nextInt();

        int x1 = in.nextInt();
        int x2 = in.nextInt();

        int y1 = in.nextInt();
        int y2 = in.nextInt();

        long[][] dp1 = new long[n][m];
        long[][] dp2 = new long[n][m];
        dp1[x1-1][x2-1] = 1;
        dp2[y1-1][y2-1] = 1;

        int i = x1-1;
        int j = y1-1;

        while(i<=j){
            for(int k=0;k<m;k++){
                if(k!=0) dp1[i+1][k-1] += dp1[i][k];
                if(k!=m-1) dp1[i+1][k+1] += dp1[i][k];
                dp1[i+1][k] += dp1[i][k];
            }
            ++i;

            for(int k=0;k<m;k++){
                if(k!=0) dp2[j-1][k-1] += dp2[j][k];
                if(k!=m-1) dp2[j-1][k+1] += dp2[j][k];
                dp2[j-1][k] += dp2[j][k];
            }
            --j;
        }

        System.out.println(Arrays.deepToString(dp1));
        System.out.println(Arrays.deepToString(dp2));

        // 小美往下的情況  j++
        if(i-j == 1){
            j++;
        }else {
            //小团往上的情况
            j++;
            i--;
        }

        System.out.println(i);
        System.out.println(j);

        long sum_xiaomei = 0;
        long sum_xiaotuan = 0;
        long total_pengzhuang = 0;

        for(int k=0;k<m;k++){
            total_pengzhuang += dp1[i][k]*dp2[j][k];
            total_pengzhuang %= mod;

            sum_xiaomei += dp1[i][k];
            sum_xiaomei %= mod;

            sum_xiaotuan += dp2[j][k];
            sum_xiaotuan %= mod;
        }

        System.out.println("total_pengzhuang:"+total_pengzhuang);
        System.out.println("sum_xiaomei*sum_xiaotuan:"+sum_xiaomei*sum_xiaotuan);
        long result = (total_pengzhuang * modInverse(sum_xiaomei * sum_xiaotuan % mod, mod)) % mod;
        System.out.println(result);
    }

    // 计算模逆元
    private static long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private static long pow(long x, long y, int p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
