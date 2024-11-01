import java.util.Arrays;
import java.util.Scanner;

public class xiechengQ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for(int i=0;i<q;++i){
            int op = in.nextInt();
            int l = in.nextInt()-1;
            int r = in.nextInt()-1;
            int res = nums[l];
            int flag;//1进行&运算 2进行|运算
            if(op == 1){
                flag = 1;
            }else{
                flag = 2;
            }
            for(int x=l+1;x<=r;++x){
                if(flag == 1){
                    // System.out.println(x);
                    // System.out.println(res);
                    // System.out.println(nums[x]);
                    // System.out.println(res & nums[x]);
                    // System.out.println();
                    res &= nums[x];
                }else{
                    res |= nums[x];
                }
                flag = 3 - flag;
            }
            System.out.println(res);
        }
    }
}
