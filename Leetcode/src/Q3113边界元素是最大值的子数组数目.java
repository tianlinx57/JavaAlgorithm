import java.util.ArrayDeque;
import java.util.Deque;

public class Q3113边界元素是最大值的子数组数目 {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        Deque<int[]> deque = new ArrayDeque<>();
        // Stack<Integer> stack = new Stack<>();
        // stack.get(1);

        deque.offer(new int[]{Integer.MAX_VALUE,0});
        long ans = 0;

        for(int i=0;i<n;i++){
            while (nums[i] > deque.getLast()[0]){
                ans += deque.removeLast()[1];
            }
            if(nums[i] == deque.getLast()[0]){
                int[] temp = deque.getLast();
                deque.offer(new int[]{temp[0],temp[1]+1});
            } else {
                deque.offer(new int[]{nums[i],1});
            }
        }
        while (!deque.isEmpty()){
            ans += deque.removeLast()[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3113边界元素是最大值的子数组数目 solution = new Q3113边界元素是最大值的子数组数目();
        System.out.println(solution.numberOfSubarrays(new int[]{1,4,3,3,2}));
    }
}