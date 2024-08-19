import java.util.*;

public class CF1996B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int k = in.nextInt();
            String[] nums = new String[n];
            for(int i = 0; i < n; i++){
                nums[i] = in.next();
                // System.out.println(nums[i]);
            }

            int new_n = n/k;
            for(int i=0;i<new_n;i++){
                for(int j=0;j<new_n;j++){
                    System.out.print(nums[k*i].charAt(k*j));
                }
                System.out.println();
            }
        }
    }
}
