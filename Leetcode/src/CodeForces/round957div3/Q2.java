package CodeForces.round957div3;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
 
        for(int i=0;i<n;i++){
            int sum = in.nextInt();
            int pieces = in.nextInt();
            int max = 0;
            for(int j=0;j<pieces;j++){
                int piece = in.nextInt();
                max = Math.max(max, piece);
            }
            System.out.println(2*(sum-max)-(pieces-1));
        }
    }



}

