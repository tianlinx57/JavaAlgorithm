import java.util.*;

public class huaweiODQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] nums = new int[n][m];
        int max = 0;
        for(int i = 0; i<n;++i){
            for(int j = 0; j<m;++j){
                nums[i][j] = in.nextInt();
                max = Math.max(max,nums[i][j]);
            }
        }
        int[] target = new int[max+1];
        int targetnum = in.nextInt();
        for(int i = 0; i<targetnum;++i){
            int temp = in.nextInt();
            if(temp > max){
                System.out.println(-1);
                return;
            }
            target[temp]++;
        }
        int[][] lieCount = new int[m][max+1];
        for(int j=0; j<m;++j){
            for(int i = 0; i<n;++i){
                lieCount[j][nums[i][j]]++;
            }
        }

        int i=0,j=0;
        int res = 1000;
        while(j<m){
            delete(lieCount,target,j);
            if(check(target)){//check true表示都小于等于0 范围内满足条件
                
                while(check(target)){
                    res = Math.min(res,j-i+1);
                    add(lieCount,target,i);
                    ++i;
                }
                delete(lieCount, target, i-1);
                --i;
            }
            ++j;
        }
        System.out.println(res);
    }

    static void delete(int[][] lieCount,int[] target,int j){
        int n = lieCount[j].length;
        for(int i=1;i<n;++i){
            target[i] -= lieCount[j][i];
        }
    }
    static void add(int[][] lieCount,int[] target,int j){
        int n = lieCount[j].length;
        for(int i=1;i<n;++i){
            target[i] += lieCount[j][i];
        }
    }
    static boolean check(int[] target){
        for(int i=1;i<target.length;++i){
            if(target[i] > 0) return false;
        }
        return true;
    }

    
}
