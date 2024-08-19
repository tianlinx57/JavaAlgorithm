package CodeForces.Round956;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i=0;i<n;i++){
            int a = in.nextInt();
            for(int j=1;j<=a;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }



}

