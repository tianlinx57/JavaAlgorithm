// 209题 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0。

class zuixiao_zishuzu {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int slowIndex = 0, sum = 0;
        int fastIndex = 0;
        for(; fastIndex < nums.length; fastIndex++){
            sum += nums[fastIndex];
            if(sum >= target){
                res = fastIndex;
                break;
            }
        }
        if(fastIndex == nums.length){
            return 0;
        }
        fastIndex++;
        while(fastIndex < nums.length && slowIndex < fastIndex){
            sum -= nums[slowIndex];
            if(sum >= target){
                slowIndex++;
                res = Integer.min(fastIndex - slowIndex,res);
                continue;
            }
            sum += nums[fastIndex];
            fastIndex++;
            slowIndex++;

        }
        while(slowIndex < fastIndex){
            sum -= nums[slowIndex];
            if(sum >= target){
                slowIndex++;
                res = Integer.min(fastIndex - slowIndex,res);
                continue;
            }
            break;
        }
        return res;

    }

    public static void main(String[] args) {
        zuixiao_zishuzu example = new zuixiao_zishuzu();
        int[] ints1 = {2,3,1,2,4,3};
        int[] ints2 = {1,4,4};
        System.out.println(example.minSubArrayLen(7,ints1));
        System.out.println(example.minSubArrayLen(4,ints2));
    }
}
