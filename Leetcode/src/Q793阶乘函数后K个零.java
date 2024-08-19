import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q793阶乘函数后K个零 {
    public int preimageSizeFZF(int k) {
        long kjia1_first = search(k);
        long k_first = search(k-1);
        System.out.println(kjia1_first);
        System.out.println(k_first);
        return (int) (kjia1_first - k_first);
    }

    //二分 找大于k的第一个值
    public long search(int k){
        long left = -1, right = 10_000_000_000L;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (f(mid) <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long f(long x) {
        long chushu = 5;
        long ans = 0;
        while (chushu<=x){
            ans += x/chushu;
            chushu *= 5;
        }
        return ans;
    }
    public static void main(String[] args) {
        Q793阶乘函数后K个零 solution = new Q793阶乘函数后K个零();
        // System.out.println(solution.preimageSizeFZF(5));
        System.out.println(solution.preimageSizeFZF(0));
    }
}