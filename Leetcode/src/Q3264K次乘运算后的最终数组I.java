import java.util.Arrays;

public class Q3264K次乘运算后的最终数组I {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i=0;i<k;i++){
            int min = Arrays.stream(nums).min().getAsInt();
            for(int j=0;j< nums.length;j++){
                if(nums[j]==min) {
                    nums[j] *= multiplier;
                    break;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Q3264K次乘运算后的最终数组I solution = new Q3264K次乘运算后的最终数组I();
        System.out.println(Arrays.toString(solution.getFinalState(new int[]{2,1,3,5,6}, 5,2)));
    }
}