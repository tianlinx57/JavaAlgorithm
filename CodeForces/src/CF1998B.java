import java.util.*;

public class CF1998B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();
            }
            for(int i=0;i<n-1;i++){
                System.out.print(nums[i+1]+" ");
            }
            System.out.println(nums[0]);

        }
    }
}
