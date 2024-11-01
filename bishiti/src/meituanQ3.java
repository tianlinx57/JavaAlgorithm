import java.util.Arrays;
import java.util.Scanner;

public class meituanQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] baozhiqi = new int[m];
        int[] zhonglei = new int[m];
        for(int i=0;i<m;i++){
            baozhiqi[i] = in.nextInt();
        }
        for(int i=0;i<m;i++){
            zhonglei[i] = in.nextInt();
        }

        
        for(int i=0;i<n;i++){
            int l = in.nextInt();
            int r = in.nextInt();
            int xiai = in.nextInt();
            int shuliang = in.nextInt();
            int[] baozhiqi_temp = Arrays.copyOfRange(baozhiqi, l,r+1);
            Arrays.sort(baozhiqi_temp);
            int count = 0;
            int flag = 0;
            int index = 0;
            for(int j=l;j<=r;i++){
                if(baozhiqi[j]==baozhiqi_temp[index] && zhonglei[j]==xiai){
                    System.out.print(j+" ");
                    flag = 1;
                    break;
                }
            }
            if(flag==1){
                index++;

            }

        }
    }
}
