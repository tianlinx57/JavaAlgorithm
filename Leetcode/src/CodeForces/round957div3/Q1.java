package CodeForces.round957div3;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int ans = 0;
            for(int j=0;j<=5;j++){
                for(int k=0;k<=5-j;k++){
                    int l = 5-j-k;
                    ans = Math.max(ans, (a+j)*(b+k)*(c+l));
                }
            }
            System.out.println(ans);
        }

    }



}
