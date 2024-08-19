import java.util.Arrays;
import java.util.Scanner;

public class CF1994A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] nums = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    nums[i][j] = in.nextInt();
                }
            }
            if( n == 1 && m == 1){
                System.out.println(-1);
                continue;
            }

            if( n != 1){
                for(int i=0;i<m;i++){
                    
                    int temp = nums[0][i];
                    for(int j=1;j<n;j++){
                        nums[j-1][i] = nums[j][i];
                    }
                    nums[n-1][i] = temp;
                }
            } else{
                for(int i=0;i<n;i++){
                    int temp = nums[i][0];
                    for(int j=1;j<m;j++){
                        nums[i][j-1] = nums[i][j];
                    }
                    nums[i][m-1] = temp;
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(nums[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
