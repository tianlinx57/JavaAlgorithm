import java.util.Arrays;

public class Q100305_K秒后第N个元素的值 {
    public int valueAfterKSeconds(int n, int k) {
        int mod = 1_000_000_007;
        int[] array = new int[n];
        Arrays.fill(array,1);
        for(int i=1;i<=k;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum += array[j];
                sum %= mod;
                array[j] = sum;
            }
        }
        return array[n-1];
    }

    public static void main(String[] args) {
        Q100305_K秒后第N个元素的值 solution = new Q100305_K秒后第N个元素的值();
        System.out.println(solution.valueAfterKSeconds(4,5));
    }
}