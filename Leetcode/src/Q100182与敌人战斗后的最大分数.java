import java.util.Arrays;

public class Q100182与敌人战斗后的最大分数 {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        if(currentEnergy < enemyEnergies[0]) return 0;
        int n = enemyEnergies.length;
        long sum = currentEnergy;
        for(int i=1;i<n;i++){
            sum += enemyEnergies[i];
        }
        return sum / enemyEnergies[0];
    }

    public static void main(String[] args) {
        Q100182与敌人战斗后的最大分数 solution = new Q100182与敌人战斗后的最大分数();
        ClassLoader classLoader1 = solution.getClass().getClassLoader();
        System.out.println(classLoader1);
        System.out.println(classLoader1.getParent());
        System.out.println(classLoader1.getParent().getParent());
    }
}