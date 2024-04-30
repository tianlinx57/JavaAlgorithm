import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II_90 {
    // Set<List<Integer>> res = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] dp_used = new boolean[10];

    void dfs(int startIndex, int[] nums){
        res.add(new ArrayList<>(path));
        if(startIndex==nums.length){
            return;
        }

        for(int i=startIndex;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]&&dp_used[i-1]==false){
                continue;
            }
            dp_used[i] = true;
            path.add(nums[i]);
            dfs(i+1,nums);
            dp_used[i] = false;
            path.removeLast();
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums);
        return res;
    }


    public static void main(String[] args) {
        子集II_90 solution = new 子集II_90();
        // System.out.println(solution.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(solution.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}