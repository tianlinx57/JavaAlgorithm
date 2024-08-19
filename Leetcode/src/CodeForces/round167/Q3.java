// package CodeForces.round167;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

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
