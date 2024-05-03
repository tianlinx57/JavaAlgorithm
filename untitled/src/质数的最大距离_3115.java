// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 质数的最大距离_3115 {
    public static void main(String[] args) {
        质数的最大距离_3115 main = new 质数的最大距离_3115();
        System.out.println(main.maximumPrimeDifference(new int[]{4,2,9,5,3}));
    }
    public int maximumPrimeDifference(int[] nums) {
        int i=0,j=nums.length-1;
        int flagi=0,flagj=0;
        while(true){

            if(flagj==1&&flagi==1){
                return j-i;
            }

            if(flagi == 0){
                if(isPrime(nums[i])){
                    flagi = 1;
                }
                else {
                    i++;
                }
            }
            if(flagj == 0){
                if(isPrime(nums[j])){
                    flagj = 1;
                }
                else {
                    j--;
                }
            }
        }
    }

    boolean isPrime(int i){
        if(i==1) return false;
        boolean flag=true;
        for(int j=2;j<=i/2;j++){
            if (i%j ==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}