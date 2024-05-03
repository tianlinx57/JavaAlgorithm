public class 买卖股票的最佳时机_121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }


    public static void main(String[] args) {
        买卖股票的最佳时机_121 solution = new 买卖股票的最佳时机_121();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        // System.out.println(solution.combinationSum3(2,18));
    }
}