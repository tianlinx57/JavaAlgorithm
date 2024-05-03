import java.util.Arrays;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 单面值组合的第K小金额_3116_二分查找 {
    public static void main(String[] args) {
        单面值组合的第K小金额_3116_二分查找 main = new 单面值组合的第K小金额_3116_二分查找();
        // System.out.println(main.findKthSmallest(new int[]{3,6,9},3));
        // System.out.println(main.findKthSmallest(new int[]{6,5},1435065516));
        System.out.println(main.findKthSmallest(new int[]{15,23,20,19,5,11,21,7,8,25},1394920705));
    }
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        coins = filter(coins);
        var lcm = lcm(coins);
        var bit = bit(coins);
        long lo = 1, hi = (long) coins[0] * k;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(lcm, bit, mid, k)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private int[] filter(int[] coins) {
        int x = 1, n = coins.length;
        L:
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < x; j++) {
                if (coins[i] % coins[j] == 0) continue L;
            }
            coins[x++] = coins[i];
        }
        return Arrays.copyOf(coins, x);
    }

    private boolean check(long[] lcm, int[] bit, long x, int k) {
        int n = lcm.length;
        var count = 0L;
        for (int i = 1; i < n; i++) count += x / lcm[i] * bit[i];
        return count >= k;
    }

    private long[] lcm(int[] coins) {
        int n = coins.length, m = 1 << n;
        var lcm = new long[m];
        lcm[0] = 1;
        for (int i = 0; i < n; i++) {
            int hi = 1 << i;
            for (int lo = 0; lo < hi; lo++) {
                lcm[hi + lo] = lcm(coins[i], lcm[lo]);
            }
        }
        return lcm;
    }

    private int[] bit(int[] coins) {
        int n = coins.length, m = 1 << n;
        var bit = new int[m];
        bit[0] = -1;
        for (int i = 0; i < n; i++) {
            int hi = 1 << i;
            for (int lo = 0; lo < hi; lo++) {
                bit[hi + lo] = -bit[lo];
            }
        }
        return bit;
    }

    private long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }

    private long gcd(long x, long y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}