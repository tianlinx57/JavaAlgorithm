package CodeForces.round958div2;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();

        for(int i=0;i<times;i++){
            int n = in.nextInt();
            int k = in.nextInt();

            int temp = (n-1)/(k-1);
            if((n-1)%(k-1)!=0){
                temp++;
            }

            System.out.println(temp);
        }

    }



}
