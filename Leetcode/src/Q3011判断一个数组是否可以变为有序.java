import java.util.HashMap;

public class Q3011判断一个数组是否可以变为有序 {

    public boolean canSortArray(int[] nums) {
        int lastMax = Integer.MIN_VALUE;
        int nowMin = nums[0];
        int nowMax = nums[0];
        int bitcount = Integer.bitCount(nums[0]);
        for(int i:nums){
            if(Integer.bitCount(i) == bitcount){
                nowMax = Math.max(nowMax, i);
                nowMin = Math.min(nowMin, i);
            } else{
                bitcount = Integer.bitCount(i);
                lastMax = nowMax;
                nowMax = i;
                nowMin = i;
            }
            if(nowMin < lastMax){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Q3011判断一个数组是否可以变为有序 solution = new Q3011判断一个数组是否可以变为有序();
        System.out.println(solution.canSortArray(new int[]{8,4,2,30,15}));
    }
}