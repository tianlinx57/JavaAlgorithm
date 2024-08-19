import java.math.BigInteger;
import java.util.Arrays;

public class Q100319执行操作可获得的最大总奖励I_bitset优化 {
    public int maxTotalReward(int[] rewardValues) {
        BigInteger f = BigInteger.ONE;
        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
            System.out.println(f.toString(2));
        }
        System.out.println();
        return f.bitLength() - 1;
    }


    public static void main(String[] args) {
        Q100319执行操作可获得的最大总奖励I_bitset优化 solution = new Q100319执行操作可获得的最大总奖励I_bitset优化();
        System.out.println(solution.maxTotalReward(new int[]{1,1,3,3}));
    }
}