// 注意类名必须为 Main, 不要有任何 package xxx 信息
// 回溯超时 要用动态规划
public class Q3129找出所有稳定的二进制数组I {
    public static void main(String[] args) {
        Q3129找出所有稳定的二进制数组I main = new Q3129找出所有稳定的二进制数组I();
        System.out.println(main.numberOfStableArrays(20,15,75));

        // System.out.println(3247943160L % (Math.pow(10,9)+7));
        // System.out.println((int) (3247943160L % (Math.pow(10,9)+7)));
    }

    long ans=0;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dfs(one,zero,limit,0,true);
        return (int) (ans%(int)(Math.pow(10,9)+7));
    }
    // b为true上个是1 false上个为0
    void dfs(int one,int zero,int limit,int numberInRow, boolean b){

        if(limit < numberInRow||one<0||zero<0) return;


        if(one==0&&zero==0 || one==0&&limit>=zero+numberInRow || zero==0&&limit>=one+numberInRow){
            ans = (ans+1)%(int)(Math.pow(10,9)+7);
            return;
        }

        if(limit>=one+zero+numberInRow){

            int min = Math.min(one,zero);
            int sum = one+zero;
            long res = 1;
            for(int i=0;i<min;i++){
                res *= sum-i;
                res /= i+1;
                // res = res % (long) (Math.pow(10,9)+7);
            }
            ans = (ans+res)%(long)(Math.pow(10,9)+7);
            // System.out.println(one);
            // System.out.println(zero);
            // System.out.println(res);
            // System.out.println();
            return;
        }


        if(b){
            dfs(one-1,zero,limit,numberInRow+1,true);
            dfs(one,zero-1,limit,1,false);
        } else {
            dfs(one-1,zero,limit,1,true);
            dfs(one,zero-1,limit,numberInRow+1,false);
        }
    }


}