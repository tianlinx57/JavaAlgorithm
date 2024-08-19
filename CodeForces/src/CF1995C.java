import java.util.*;

public class CF1995C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        outer:for(;Cases>0;Cases--) {
            int n = in.nextInt();
            double[] nums = new double[n];
            for(int i=0;i<n;i++){
                nums[i] = in.nextDouble();
                nums[i] = Math.log(nums[i]);
            }

            long ans = 0;
            for(int i=1;i<n;i++){
                if(nums[i] == 0 && nums[i-1] != 0){
                    System.out.println("-1");
                    continue outer;
                }
                while(nums[i] < nums[i-1]){
                    nums[i] *= 2;
                    ++ans;
                }
            }
            System.out.println(ans);
        }
    }
}
