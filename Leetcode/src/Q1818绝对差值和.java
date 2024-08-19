import java.util.Arrays;

public class Q1818绝对差值和 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int ans = 0;
        int mod = 1_000_000_007;

        int n = nums1.length;
        for(int i=0;i<n;i++){
            ans += Math.abs(nums1[i] - nums2[i]);
            ans %= mod;
        }
        int[] sortedNums1 = Arrays.stream(nums1).sorted().toArray();

        int biggestChange=0;
        for(int i=0;i<n;i++){
            int smallerOne = find(sortedNums1,nums2[i]);
            biggestChange = Math.max(biggestChange,Math.abs(nums1[i] - nums2[i]) - Math.abs(sortedNums1[smallerOne] - nums2[i]));
            biggestChange = Math.max(biggestChange,Math.abs(nums1[i] - nums2[i]) - Math.abs(sortedNums1[(smallerOne+1)%n] - nums2[i]));
        }
        System.out.println(ans);
        System.out.println(biggestChange);
        return (mod + ans - biggestChange)%mod;
    }

    int find(int[] nums, int target){
        int i=0,j=nums.length;
        while(i+1<j){
            int mid = i+(j-i)/2;
            if(nums[mid] < target){
                i = mid;
            } else {
                j = mid;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        Q1818绝对差值和 solution = new Q1818绝对差值和();
        System.out.println((-20743)%1_000_000_007);
        System.out.println(solution.minAbsoluteSumDiff(new int[]{1,7,5},new int[]{2,3,5}));
        System.out.println("哈哈哈哈！！！！！");
    }
}