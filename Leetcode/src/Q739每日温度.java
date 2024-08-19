import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q739每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for(int i=temperatures.length-1;i>=0;i--){
            // System.out.println(deque);
            if(deque.isEmpty()){
                deque.offer(i);
                ans[i] = 0;
                continue;
            }

            while(!deque.isEmpty() && temperatures[deque.getLast()] <= temperatures[i]){
                deque.removeLast();
            }

            if(deque.isEmpty()) {
                ans[i] = 0;
            }
            else{
                ans[i] = deque.getLast() - i;
            }
            deque.offer(i);

            // System.out.println(deque);
            // System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        Q739每日温度 solution = new Q739每日温度();
        Deque<Integer> deque = new ArrayDeque<>();

        // deque.offer(1);
        // deque.offer(2);
        // System.out.println(deque);
        // System.out.println(deque.getLast());

        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // [1,1,4,2,1,1,0,0]
        // System.out.println(solution.combinationSum3(2,18));
    }
}