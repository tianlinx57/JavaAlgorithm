public class Q3096得到更多分数的最少关卡数目 {
    public int minimumLevels(int[] possible) {
        int n= possible.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(possible[i] ==1){
                sum+=1;
            }else {
                sum-=1;
            }
        }
        int qinzuihe = 0;

        for(int i=0;i<n-1;i++){
            if(possible[i] ==1){
                qinzuihe+=1;
            }else {
                qinzuihe-=1;
            }
            if(qinzuihe*2 > sum){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q3096得到更多分数的最少关卡数目 main = new Q3096得到更多分数的最少关卡数目();
        // System.out.println(main.minimumSubarrayLength(new int[]{2,1,8},10));
        System.out.println(main.minimumLevels(new int[]{1,0,1,0}));
    }

}