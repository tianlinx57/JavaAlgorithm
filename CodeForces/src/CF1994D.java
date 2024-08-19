import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CF1994D {
    static String string = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();
            }
            int[] used = new int[n];
            used[0] = 1;
            if(!dfs(nums, used, 1)){
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.print(string);
            }
            string = "";
        }
    }

    static boolean dfs(int[] nums, int[] used, int chushu){
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(used));
        // System.out.println(chushu);
        // System.out.println();
        if(chushu == nums.length){
            return true;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]!=0){
                continue;
            }
            for(int j=0;j<nums.length;j++){
                if(used[j]==0){
                    continue;
                }
                if(Math.abs(nums[i]-nums[j]) % chushu != 0){
                    continue;
                }
                used[i] = 1;
                if(dfs(nums, used, chushu+1)){
                    string = (i+1)+" "+(j+1)+"\n"+string;
                    
                    used[i] = 0;
                    return true;
                }
                used[i] = 0;
            }
        }
        return false;
    }
}
