import java.util.Arrays;
import java.util.Scanner;

public class dewu_10_16_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int length = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(length>=nums[i]){
                ++length;
                continue;
            }
            break;
        }
        System.out.println(length);
    }
}
