import java.util.Arrays;
import java.util.PriorityQueue;

public class week138doubleQ4对Bob造成的最少伤害 {
    public long minDamage(int power, int[] damage, int[] health) {
        long ans = 0;
        int n = damage.length;
        long damagesum = 0;
        for (int i = 0; i < n; ++i) {
            health[i] = health[i]/power + (health[i]%power==0?0:1);
            damagesum += damage[i];
        }
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            // 比较第一个元素
            if (a[0] != b[0]) {
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(a[1], b[1]);
        });
        for(int i=0;i<n;i++){
            priorityQueue.offer(new double[]{(double)health[i]/damage[i],i});
        }
        while (!priorityQueue.isEmpty()){
            double[] cur = priorityQueue.poll();
            int index = (int)cur[1];
            ans += health[index]*damagesum;
            damagesum -= damage[index];
        }
        return ans;
    }
    public static void main(String[] args) {
        week138doubleQ4对Bob造成的最少伤害 solution = new week138doubleQ4对Bob造成的最少伤害();
        System.out.println(solution.minDamage(4,new int[]{1,2,3,4},new int[]{4,5,6,8}));
    }
}