public class Q3095或值至少K的最短子数组I_自己写 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int temp = k;
        int[][] wei_sum = new int[40][2];


        int ans = Integer.MAX_VALUE;

        int j=0;
        for(int i=0;i<n;i++){
            add(nums[i],wei_sum);
            // System.out.println(Arrays.deepToString(wei_sum));
            if(check(wei_sum,temp)){
                ans = Math.min(i-j+1,ans);
            }else {
                continue;
            }
            for(;j<=i;j++){
                delete(nums[j],wei_sum);
                if(!check(wei_sum,temp)){
                    add(nums[j],wei_sum);
                    ans = Math.min(i-j+1,ans);
                    break;
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    void add(int a,int[][] wei_sum){
        int i=0;
        while (a!=0){
            if((a&1) == 1){
                wei_sum[i][1] ++;
            }
            wei_sum[i][0]=1;
            ++i;
            a >>= 1;
        }
    }
    void delete(int a,int[][] wei_sum){
        int i=0;
        while (a!=0){
            if((a&1) == 1){
                wei_sum[i][1] --;
            }
            ++i;
            a >>= 1;
        }
    }
    boolean check(int[][] wei_sum, int k){
        int i=0;
        int res = 0;
        while (wei_sum[i][0]!=0){
            if(wei_sum[i][1]!=0){
                res += 1<<i;
            }
            ++i;
        }
        // System.out.println(Arrays.deepToString(wei_sum));
        // System.out.println(res);
        // System.out.println();
        return res >= k;
    }

    public static void main(String[] args) {
        Q3095或值至少K的最短子数组I_自己写 main = new Q3095或值至少K的最短子数组I_自己写();
        // System.out.println(main.minimumSubarrayLength(new int[]{2,1,8},10));
        System.out.println(main.minimumSubarrayLength(new int[]{1,2,3},2));
    }

}