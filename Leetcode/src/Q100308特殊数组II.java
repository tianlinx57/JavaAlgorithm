import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;


public class Q100308特殊数组II {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        int jiou = nums[0]%2;
        for(int i=1;i<n;i++){
            int temp = nums[i]%2;
            if(temp == jiou){
                treeSet.add(i);
            }
            jiou = temp;
        }
        n = queries.length;
        boolean[] ans = new boolean[n];
        for(int i=0;i<n;i++){
            if(existsInRange(treeSet,queries[i][0],queries[i][1])){
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }
        return ans;
    }

    public static boolean existsInRange(TreeSet<Integer> treeSet, int start, int end) {
        NavigableSet<Integer> subSet = treeSet.subSet(start, false, end, true);
        return !subSet.isEmpty();
    }

    public static void main(String[] args) {
        Q100308特殊数组II solution = new Q100308特殊数组II();
        System.out.println(Arrays.toString(solution.isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));

    }
}