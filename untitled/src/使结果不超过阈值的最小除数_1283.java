import java.util.Arrays;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 使结果不超过阈值的最小除数_1283 {
    public static void main(String[] args) {
        使结果不超过阈值的最小除数_1283 main = new 使结果不超过阈值的最小除数_1283();
        // System.out.println(main.findKthSmallest(new int[]{3,6,9},3));
        // System.out.println(main.findKthSmallest(new int[]{6,5},1435065516));
        System.out.println(main.smallestDivisor(new int[]{1,2,5,9},6));
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1, j = Arrays.stream(nums).max().getAsInt();


        while(i<j){
            // System.out.println("i:"+i);
            // System.out.println("j:"+j);
            // System.out.println();
            int mid = (i+j)/2;
            if(check(nums,mid,threshold)){
                i=mid+1;
            } else{
                j=mid;
            }

        }

        return i;
    }

    boolean check(int[] nums,int mid,int threshold){
        int sum = 0;
        for(int i:nums){
            // System.out.println("i/mid:"+i/mid);
            sum += i/mid;
            if(i%mid != 0) sum++;
        }
        // System.out.println("sum:"+sum);
        // System.out.println();
        return sum >= threshold;
    }

}