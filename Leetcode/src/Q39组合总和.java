import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39组合总和 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    void dfs(int startIndex, int target, int sum, int[] candidates){
        // System.out.println("startIndex:"+startIndex);
        // System.out.println("target:"+target);
        // System.out.println("sum:"+sum);
        // System.out.println();

        if(sum==target){
            result.add(new ArrayList<>(path));
            // System.out.println(result);
            return;
        } else if (sum>target) {
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(i,target,sum+candidates[i],candidates);
            path.removeLast();
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,target,0,candidates);
        return result;
    }


    public static void main(String[] args) {
        Q39组合总和 solution = new Q39组合总和();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
        // System.out.println(solution.combinationSum3(2,18));
    }
}