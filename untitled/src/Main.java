
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
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