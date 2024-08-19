public class Q100338子数组按位与值为K的数目 {

    class Solution {

        public long countSubarrays(int[] nums, int k) {
            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & k) == k) {
                    ++sum;
                }
            }
            long ans = 0;
            for (int i = 1; i <= sum; i++) {
                ans += C(sum, i);
            }
            if (sum == n) ans--;
            return ans;
        }

        private long C(int n, int k) {
            long ans = 1;
            for (int i = n; i >= n - k + 1; i--) {
                ans *= i;
            }
            for (int i = 1; i <= k; i++) {
                ans /= i;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Q100338子数组按位与值为K的数目 outer = new Q100338子数组按位与值为K的数目();
        Solution solution = outer.new Solution();
        System.out.println(solution.countSubarrays(new int[]{1, 1, 1}, 1)); // Expected output: 6
        System.out.println(solution.countSubarrays(new int[]{1, 1, 2}, 1)); // Expected output: 3
        System.out.println(solution.countSubarrays(new int[]{1, 2, 3}, 2)); // Expected output: 2
        System.out.println(solution.countSubarrays(new int[]{0, 1, 0, 0, 1, 0, 1}, 6)); // Adjust this based on logic
    }
}
