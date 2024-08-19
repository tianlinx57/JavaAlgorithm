import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Q3116单面值组合的第K小金额 {
    public static void main(String[] args) {
        Q3116单面值组合的第K小金额 main = new Q3116单面值组合的第K小金额();
        // System.out.println(main.findKthSmallest(new int[]{3,6,9},3));
        // System.out.println(main.findKthSmallest(new int[]{6,5},1435065516));
        System.out.println(main.findKthSmallest(new int[]{15,23,20,19,5,11,21,7,8,25},1394920705));
    }
    public long findKthSmallest(int[] coins, int k) {
        coins = Arrays.stream(coins).sorted().toArray();
        // System.out.println(Arrays.toString(coins));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            boolean canDivide = false;
            for (int j = 0; j < list.size(); j++) {
                if (coins[i] % list.get(j) == 0) {
                    canDivide = true;
                    break;
                }
            }
            if (!canDivide) {
                list.add(coins[i]);
            }
        }
        // System.out.println(list.toString());
        coins = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            coins[i] = list.get(i);
        }
        // System.out.println(Arrays.toString(coins));



        ResultType res=zuixiaoGongbei(coins,k);
        if(res.end == false){
            long times = k/res.numsInZuixiaoGongbei;
            long divided = k%res.numsInZuixiaoGongbei;
            return times*res.res+zuixiaoGongbei(coins, (int) divided).res;
        } else {
            return res.res;
        }

    }

    ResultType zuixiaoGongbei(int[] coins, int k){
        ResultType res = new ResultType();

        long[] list = new long[coins.length];
        for(int i=0;i<coins.length;i++){
            list[i] = coins[i];
        }

        long min = 0;
        int[] divided = new int[list.length];
        for(long i =0;i<k;i++){
            min = Long.MAX_VALUE;
            for(int j =0;j< list.length;j++){
                min = Long.min(list[j],min);
            }

            for(int j =0;j< list.length;j++){
                if(list[j] == min){
                    list[j] += coins[j];
                    divided[j] = 1;
                }else {
                    divided[j] = 0;
                }
            }
            if(Arrays.stream(divided).sum() == coins.length){
                res.setEnd(false);
                res.setNumsInZuixiaoGongbei(i+1);
                res.setRes(min);
                return res;
            }
        }
        res.setEnd(true);
        res.setRes(min);
        return res;
    }

    class ResultType{
        boolean end;
        long numsInZuixiaoGongbei;
        long res;
        public void setEnd(boolean end) {
            this.end = end;
        }
        public void setNumsInZuixiaoGongbei(long numsInZuixiaoGongbei) {
            this.numsInZuixiaoGongbei = numsInZuixiaoGongbei;
        }

        public void setRes(long res) {
            this.res = res;
        }
    }

}