import java.util.ArrayList;
import java.util.List;

public class 目标和_494_回溯 {
    int sum=0;
    int res=0;
    List<Character> list = new ArrayList<Character>();
    void dfs(int startIndex, int[] nums, int target){
        if(sum == target && startIndex == nums.length){
            res++;
            System.out.println(list.toString());
            return;
        }
        if(startIndex == nums.length){
            return;
        }
        sum += nums[startIndex];
        list.add('+');
        dfs(startIndex+1,nums,target);
        list.removeLast();

        list.add('-');
        sum -= nums[startIndex]*2;
        dfs(startIndex+1,nums,target);
        sum += nums[startIndex];
        list.removeLast();

    }
    public int findTargetSumWays(int[] nums, int target) {
        dfs(0,nums,target);
        return res;
    }

    public static void main(String[] args) {
        目标和_494_回溯 solution = new 目标和_494_回溯();
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}