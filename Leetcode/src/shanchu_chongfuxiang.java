import java.util.Arrays;

class shanchu_chongfuxiang {

    public int removeDuplicates(int[] nums) {
        int slowIndex=0,fastIndex=0;
        for(;fastIndex<nums.length;fastIndex++) {
            if(nums[slowIndex] != nums[fastIndex]){
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex+1;
    }

    public static void main(String[] args) {
        shanchu_chongfuxiang example = new shanchu_chongfuxiang();
        int[] ints1 = {1, 1, 2};
        int[] ints2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(example.removeDuplicates(ints1));
        System.out.println(Arrays.toString(ints1));
        System.out.println(example.removeDuplicates(ints2));
        System.out.println(Arrays.toString(ints2));
    }
}
