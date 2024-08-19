import java.util.Arrays;

public class Q3159查询数组中元素的出现位置 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] places = new int[100000];
        int n = nums.length;
        int m = queries.length;

        int flag = 1;
        for(int i=0;i<n;i++){
            if(nums[i] == x){
                places[flag] = i;
                ++flag;
            }
        }

        // System.out.println(Arrays.toString(queries));

        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            if(queries[i]>=flag) {
                ans[i] = -1;
                continue;
            }
            ans[i] = places[queries[i]];
        }

        return ans;
    }

    public static void main(String[] args) {
        Q3159查询数组中元素的出现位置 solution = new Q3159查询数组中元素的出现位置();

        System.out.println(Arrays.toString(solution.occurrencesOfElement(new int[]{1,3,1,7}, new int[]{1,3,2,4},1)));
    }
}