import java.util.ArrayDeque;
import java.util.Deque;

public class Q100324清除数字 {
    public String clearDigits(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(chars[i]>='0' && chars[i] <= '9'){
                deque.removeLast();
            }else {
                deque.offer(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q100324清除数字 solution = new Q100324清除数字();

        // System.out.println(solution.maxOperations(new int[]{3,2,1,2,3,4}));
        System.out.println(solution.clearDigits("cb34"));
    }
}