//100257. 找出唯一性数组的中位数
// 困难
// 相关企业
// 提示
// 给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有
// 非空子数组中
// 不同元素的个数。
//
// 换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。
//
// 其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。
//
// 返回 nums 唯一性数组 的 中位数 。
//
// 注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3]
//
// 输出：1
//
// 解释：
//
// nums 的唯一性数组为 [distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]), distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]，即 [1, 1, 1, 2, 2, 3] 。唯一性数组的中位数为 1 ，因此答案是 1 。
//
// 示例 2：
//
// 输入：nums = [3,4,3,4,5]
//
// 输出：2
//
// 解释：
//
// nums 的唯一性数组为 [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。
//
// 示例 3：
//
// 输入：nums = [4,3,5,4]
//
// 输出：2
//
// 解释：
//
// nums 的唯一性数组为 [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。

import java.util.Arrays;

public class Q100257找出唯一性数组的中位数 {
    int[][] dp;
    int[] res;
    public int medianOfUniquenessArray(int[] nums) {
        dp = new int[nums.length+2][nums.length];
        res = new int[nums.length+1];
        dp[1][0] = 1;
        res[1] += 1;

        for(int i=1;i<nums.length;i++){
            dp[1][i] = 1;
            res[1] += 1;

            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    for(int k=2;;k++){
                        if(dp[k-1][j]==0) break;
                        dp[k][i] += dp[k-1][j];
                        dp[k-1][i] -= k-2;
                        res[k] += dp[k-1][j];
                        res[k-1] -= k-2;
                    }
                }
            }
        }
        for(int i=0;i<nums.length+1;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(Arrays.toString(res));

        int target=(Arrays.stream(res).sum()+1)/2;
        for(int i=1;i<=nums.length;i++){
            target-=res[i];
            if(target<=0) return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        Q100257找出唯一性数组的中位数 solution = new Q100257找出唯一性数组的中位数();
        // System.out.println(solution.medianOfUniquenessArray(new int[]{1,2,3}));
        System.out.println(solution.medianOfUniquenessArray(new int[]{3,4,3,4,5}));
    }
}