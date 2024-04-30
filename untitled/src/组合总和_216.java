import java.util.ArrayList;
import java.util.List;

public class 组合总和_216 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    void dfs(int startIndex, int target, int depth, int sum){
        // System.out.println("startIndex:"+startIndex);
        // System.out.println("target:"+target);
        // System.out.println("depth:"+depth);
        // System.out.println("sum:"+sum);
        // System.out.println();

        if(depth==0&&sum==target){
            result.add(new ArrayList<>(path));
            // System.out.println(result);
            return;
        } else if (depth==0 || sum>=target) {
            return;
        }

        for(int i=startIndex;i<=target-depth&&i<=9;i++){
            path.add(i);
            dfs(i+1,target,depth-1,sum+i);
            path.removeLast();
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,n,k,0);
        return result;
    }


    public static void main(String[] args) {
        组合总和_216 solution = new 组合总和_216();
        System.out.println(solution.combinationSum3(3,7));
        // System.out.println(solution.combinationSum3(2,18));
    }
}