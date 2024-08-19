// package CodeForces.round957div3;

import java.util.Scanner;

public class Q4 {

    static String s;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = Integer.parseInt(in.nextLine());

        for(int i=0;i<times;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            s = in.next();
            System.out.println(solve(n, m, k, 0));
        }
    }

    private static String solve(int n, int m, int k, int start) {
        // System.out.println(n + " " + m + " " + k + " " + start);
        // System.out.println();
        if(n == 0 || n < m) return "YES";

        int lastWater = Integer.MIN_VALUE;
        for(int i=m;i>=1;i--){
            if(s.charAt(start+i-1)=='L'){
                return solve(n-i, m, k, start+i);
            }
            if(s.charAt(start+i-1)=='W'){
                lastWater = Math.max(lastWater,i);
            }
        }
        if(lastWater==Integer.MIN_VALUE){
            return "NO";
        }
        return swim(n-lastWater,m,k-1,start+lastWater);
    }

    private static String swim(int n, int m, int k, int start) {
        if(k==-1) return "NO";
        if(n == 0) return "YES";
        if(s.charAt(start) == 'C') return "NO";

        if(s.charAt(start) == 'W'){
            return swim(n-1, m, k-1, start+1);
        }
        if(s.charAt(start) == 'L'){
            return solve(n-1, m, k, start+1);
        }
        return "YES";
    }



}
