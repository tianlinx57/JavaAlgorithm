// import java.util.HashMap;
import java.util.*;

public class meituant2Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n+1];
        for(int i=1;i<=n;i++){
            nums[i] = in.nextInt();
        }
        check(nums,n);
        for(int i=0;i<k;i++){
            String s = in.next();
            int l = in.nextInt();
            int r = in.nextInt();
            int x = in.nextInt();
            if(s.equals("+")){
                for(int j=l;j<=r;j++){
                    nums[j] += x;
                }
            } else {
                for(int j=l;j<=r;j++){
                    nums[j] -= x;
                }
            }
            check(nums,n);
        } 
    }
    static void check(int[] nums,int n){
        // System.out.println(Arrays.toString(nums));
        int max = 0;
        // int secondmax = 0;
        for(int i=1;i<=n;i++){
            int temp = max;
            max = Math.max(max,nums[i]);
            // if(max != nums[i]){
            //     secondmax = Math.max(secondmax,nums[i]);
            // } else{
            //     secondmax = Math.max(secondmax,temp);
            // }
        }
        // System.out.println();
        // System.out.println(max);
        // System.out.println(secondmax);
        if(n==1){
            System.out.println(-1);
            return;
        } else if(n==2){
            if(max == 1) {
                System.out.println(-1);
                return;
            }
        } 

        // if(secondmax >= 2){
        //     System.out.println(max);
        // } else{
        //     System.out.println(max-1);
        // }
        System.out.println(max-1);
    }
}
