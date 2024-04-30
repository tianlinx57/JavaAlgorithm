// 209题 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0。

class zuixiao_zishuzu_guanfang {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        zuixiao_zishuzu_guanfang example = new zuixiao_zishuzu_guanfang();
        int[] ints1 = {2,3,1,2,4,3};
        int[] ints2 = {1,4,4};
        System.out.println(example.minSubArrayLen(7,ints1));
        System.out.println(example.minSubArrayLen(4,ints2));
    }
}
