import java.util.Arrays;

//给你一个数组 nums ，它是 [0, 1, 2, ..., n - 1] 的一个
// 排列
//  。对于任意一个 [0, 1, 2, ..., n - 1] 的排列 perm ，其 分数 定义为：
//
// score(perm) = |perm[0] - nums[perm[1]]| + |perm[1] - nums[perm[2]]| + ... + |perm[n - 1] - nums[perm[0]]|
//
// 返回具有 最低 分数的排列 perm 。如果存在多个满足题意且分数相等的排列，则返回其中
// 字典序最小
// 的一个。
public class Q3149找出分数最低的排列 {
    public int[] findPermutation(int[] nums) {
        int n = nums.length;
        int mask = 1<< n;
        int[][] dp = new int[n][mask];

        for(int i=0;i<n;i++){
            
        }
        return null;
    }

    public static void main(String[] args) {
        Q3149找出分数最低的排列 solution = new Q3149找出分数最低的排列();
        System.out.println(Arrays.toString(solution.findPermutation(new int[]{1, 0, 2})));

    }
}