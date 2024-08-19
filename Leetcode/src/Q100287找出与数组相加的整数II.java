import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
// 给你两个整数数组 nums1 和 nums2。
//
// 从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
//
// 执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
//
// 返回能够实现数组相等的 最小 整数 x 。
//
//
//
// 示例 1:
//
// 输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10]
//
// 输出：-2
//
// 解释：
//
// 移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。
//
// 示例 2:
//
// 输入：nums1 = [3,5,5,3], nums2 = [7,7]
//
// 输出：2
//
// 解释：
//
// 移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。
public class Q100287找出与数组相加的整数II {
    public static void main(String[] args) {
        Q100287找出与数组相加的整数II main = new Q100287找出与数组相加的整数II();
        System.out.println(main.minimumAddedInteger(new int[]{4,20,16,12,8},new int[]{14,18,10}));
    }
    int res=Integer.MAX_VALUE;

    List<Integer> path = new ArrayList<>();

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        dfs(nums1,nums2,0,0);
        return res;
    }

    void dfs(int[] nums1, int[] nums2, int giveupNumber, int startIndex){
        // System.out.println("num1:"+ Arrays.toString(nums1));
        // System.out.println("nums2:"+ Arrays.toString(nums2));
        // System.out.println("path:"+ path);
        // System.out.println("startIndex:"+startIndex);
        // System.out.println("giveupNumber:"+giveupNumber);
        // System.out.println();

        if(giveupNumber==3){
            return;
        }
        if(startIndex-giveupNumber==nums2.length){
            // System.out.println("res:"+ res);
            // System.out.println("nums2[0]:"+ nums2[0]);
            // System.out.println("path.get(0):"+ path.get(0));
            // System.out.println();
            res=Math.min(res,nums2[0]-path.get(0));
            return;
        }

        if(startIndex==giveupNumber||nums1[startIndex]-path.getLast()==nums2[startIndex-giveupNumber]-nums2[startIndex-giveupNumber-1]){
            path.add(nums1[startIndex]);
            dfs(nums1,nums2,giveupNumber,startIndex+1);
            path.removeLast();
        }
        dfs(nums1,nums2,giveupNumber+1,startIndex+1);

    }
}