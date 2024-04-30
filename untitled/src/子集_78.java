import java.util.ArrayList;
import java.util.List;

public class 子集_78 {
    // Set<List<Integer>> res = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    void dfs(int startIndex, int[] nums){
        if(startIndex==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(startIndex+1,nums);

        path.add(nums[startIndex]);
        dfs(startIndex+1,nums);
        path.removeLast();
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        // res.add(new ArrayList<>());
        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        子集_78 solution = new 子集_78();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }
}