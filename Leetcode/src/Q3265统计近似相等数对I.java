import java.util.Arrays;

public class Q3265统计近似相等数对I {
    public int countPairs(int[] nums) {
        int n = nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(i,j,nums)){
                    ++ans;
                }
            }
        }
        return ans;
    }
    boolean check(int i,int j,int[] nums){
        int a = nums[i];
        int b = nums[j];
        int butong = 0;
        while(butong<=2 && !(a==0 && b==0)){
            if(a%10 != b%10){
                butong++;
            }
            a /= 10;
            b /= 10;
        }
        System.out.println(nums[i]);
        System.out.println(nums[j]);
        System.out.println(butong);
        System.out.println();
        if(butong <= 2) return true;
        return false;
    }
    public static void main(String[] args) {
        Q3265统计近似相等数对I solution = new Q3265统计近似相等数对I();
        System.out.println(solution.countPairs(new int[]{3,12,30,17,21}));
    }
}