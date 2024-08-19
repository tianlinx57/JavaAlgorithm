import java.util.Arrays;

public class xxxxxx {

    void output(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                if(j<i) System.out.print("");
                else {
                    sum += nums[j];
                    System.out.print(sum + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        xxxxxx solution = new xxxxxx();
        // int[] nums1 = {4,7,5,1,2,6,3};
        // solution.output(nums1);
        // int[] nums2 = {6,2,1,4,7,3,5};
        // solution.output(nums2);
        int[] nums1 = {4,7,5,1,2,6,3};
        solution.output(nums1);
        int[] nums2 = {7,5,1,2,6,3,4};
        solution.output(nums2);
        // int[] nums1 = {1,2,3,4,5};
        // solution.output(nums1);
        // int[] nums2 = {2,3,4,5,1};
        // solution.output(nums2);
    }
}