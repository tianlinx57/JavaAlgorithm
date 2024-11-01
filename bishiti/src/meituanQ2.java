import java.util.Arrays;
import java.util.Scanner;

public class meituanQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long k = in.nextLong();
        long mod = 1_000_000_007;

        long[] nums = new long[]{a,b,c};
        Arrays.sort(nums);
        long max = nums[2];
        long min = nums[0];
        long jian = Math.min(k, nums[1]-nums[0]);
        nums[0] += jian;
        k -= jian;
        a=nums[0];
        b=nums[1];
        c=nums[2];
        if(k==0) {
            System.out.println(a*b*c%mod);
            return;
        }
        long gap = c-a;
        if(gap * 2>k){
            long zengjia = k/2;
            a += zengjia;
            b += zengjia;
            a += k%2;
            // System.out.println(a);
            // System.out.println(b);
            // System.out.println(c);
            System.out.println(a*b*c%mod);
            return;
        }
        a = c;
        b = c;
        k -= gap*2;
        long jiaduoshao = k/3;
        long yushu = k%3;
        a += jiaduoshao;
        b += jiaduoshao;
        c += jiaduoshao;
        if(yushu == 1){
            a++;
        }
        if(yushu == 2){
            a++;
            b++;
        }
        System.out.println(a*b*c%mod);
    }
}
