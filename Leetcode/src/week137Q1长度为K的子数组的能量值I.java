import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class week137Q1长度为K的子数组的能量值I {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int dizeng_number = 1;
        List<Integer> ans = new ArrayList<>();
        if(k==1) ans.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i] == 1+nums[i-1]){
                dizeng_number++;
            } else {
                dizeng_number = 1;
            }
            if(i>=k-1){
                if(dizeng_number>=k){
                    ans.add(nums[i]);
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();

    }
    public static void main(String[] args) {
        week137Q1长度为K的子数组的能量值I solution = new week137Q1长度为K的子数组的能量值I();
        System.out.println(Arrays.toString(solution.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }
}