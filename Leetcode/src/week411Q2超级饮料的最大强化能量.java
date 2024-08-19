public class week411Q2超级饮料的最大强化能量 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] dpA = new long[n+1];
        long[] dpB = new long[n+1];
        dpA[0] = energyDrinkA[0];
        dpB[0] = energyDrinkB[0];
        dpA[1] = energyDrinkA[0] + energyDrinkA[1];
        dpB[1] = energyDrinkB[0] + energyDrinkB[1];

        for(int i=2;i<n;i++){
            dpA[i] = Math.max(dpA[i-1]+energyDrinkA[i],dpB[i-2]+energyDrinkA[i]);
            dpB[i] = Math.max(dpB[i-1]+energyDrinkB[i],dpA[i-2]+energyDrinkB[i]);
        }
        return Math.max(dpA[n-1],dpB[n-1]);
    }
    public static void main(String[] args) {
        week411Q2超级饮料的最大强化能量 solution = new week411Q2超级饮料的最大强化能量();
        System.out.println(solution.maxEnergyBoost(new int[]{1,3,1}, new int[]{3,1,1}));
    }
}