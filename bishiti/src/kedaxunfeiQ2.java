import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class kedaxunfeiQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[][] qs = new int[q][2];
        for(int i=0;i<q;i++){
            qs[i][0] = in.nextInt();
            qs[i][1] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.print(check(i,n,qs));
            // check(i,n,qs);
            System.out.print(" ");
        }

        
    }
    static int check(int i,int n,int[][] qs){
        // System.out.println(i);
        HashSet<Integer> set = new HashSet<>();
        set.add(i);
        for(int[] q:qs){
            int left = q[0]-1;
            int right =  q[1]-1;
            if(i>=left && i<=right){
                i = n-1-right+i;
                set.add(i);
            } else if(i>right){
                i = i-(right-left+1);
                set.add(i);
            }
        }
        // System.out.println(set);
        return set.size();
    }
}
