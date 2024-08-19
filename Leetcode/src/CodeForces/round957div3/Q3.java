package CodeForces.round957div3;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = Integer.parseInt(in.nextLine());

        for(int i=0;i<times;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            for(int j=n;j>m;j--){
                System.out.print(j+" ");
            }
            for(int j=1;j<=m;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }



}
