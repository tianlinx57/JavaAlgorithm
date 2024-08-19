import java.util.ArrayDeque;
import java.util.Deque;

public class Q100297找到连续赢K场比赛的第一位玩家 {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        if(k >= n){
            int max = 0;
            for(int i=0;i<n;i++){
                if(skills[i] > skills[max]){
                    max = i;
                }
            }
            return max;

        }

        int boss = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1;i<n;i++){
            deque.offer(i);
        }

        int count = 0;
        while(count < k){
            int challenger = deque.removeFirst();
            if(skills[boss] > skills[challenger]){
                deque.offer(challenger);
                ++count;
                continue;
            }
            deque.offer(boss);
            boss = challenger;
            count = 1;
        }
        return boss;

    }

    public static void main(String[] args) {
        Q100297找到连续赢K场比赛的第一位玩家 solution = new Q100297找到连续赢K场比赛的第一位玩家();

        // System.out.println(solution.maxOperations(new int[]{3,2,1,2,3,4}));
        // System.out.println(solution.findWinningPlayer(new int[]{4,2,6,3,9},2));
        System.out.println(solution.findWinningPlayer(new int[]{11,13,10,15,14,9,12,6},2));
    }
}