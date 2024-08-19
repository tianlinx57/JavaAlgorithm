package CodeForces.round167;// package CodeForces.round167;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // int[][] coins = new int[n][2];
        // for(int i=0;i<n;i++){
        //     coins[i][0] = in.nextInt();
        //     coins[i][1] = in.nextInt();
        // }
        //
        // for(int i=0;i<n;i++){
        //     if(coins[i][1]<=-2){
        //         System.out.println("NO");
        //     }else {
        //         System.out.println("YES");
        //     }
        // }
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();

            if(b<=-2){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }

    }



}
