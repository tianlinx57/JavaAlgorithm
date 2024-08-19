import java.util.*;

public class CF1995C_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        outer:for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int count = 0;
            long[] nums = new long[n];
            for(int i=0;i<n;i++){
                nums[i] = in.nextLong();
            }

            long ans = 0;
            for(int i=1;i<n;i++){
                // System.out.println(count);
                if(nums[i] == 1 && nums[i-1] != 1){
                    System.out.println("-1");
                    continue outer;
                }
                if(nums[i] < nums[i-1]){
                    long temp = nums[i];
                    while(temp < nums[i-1]){
                        temp *= temp;
                        count++;
                    }
                    ans += count;
                    continue;
                }
                if(nums[i] == nums[i-1]){
                    ans += count;
                    continue;
                }
                if(nums[i] > nums[i-1]){
                    long temp = nums[i-1];
                    temp *= temp;
                    while(nums[i] >= temp){
                        temp *= temp;
                        count--;
                        if(count <= 0){
                            count = 0;
                            break;
                        }
                    }
                    ans += count;
                    continue;
                }
            }
            System.out.println(ans);
            // System.out.println();
        }
    }
}
