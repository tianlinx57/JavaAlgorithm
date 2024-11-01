import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3266K次乘运算后的最终数组II {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });//最小堆 int[0]为值的大小 int[1]为序列号（index）

        int n = nums.length;
        for(int i=0;i<n;i++){
            priorityQueue.add(new int[]{nums[i],i});
        }
        while(k>0){
            --k;
            int[] peek = priorityQueue.poll();
            peek[0] *= multiplier;
            priorityQueue.add(peek);
        }
        while (!priorityQueue.isEmpty()){
            int[] peek = priorityQueue.poll();
            nums[peek[1]] = peek[0];
        }
        return nums;
    }

    //快速幂
    private long pow(long x, int n) {
        long MOD = 1_000_000_007;
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
    public static void main(String[] args) {
        Q3266K次乘运算后的最终数组II solution = new Q3266K次乘运算后的最终数组II();
        System.out.println(Arrays.toString(solution.getFinalState(new int[]{2,1,3,5,6}, 5,2)));
    }
}