import java.util.*;

public class CF1996D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int q = in.nextInt();
            String a = in.next();
            String b = in.next();
            
            for(;q>0;q--){
                int l = in.nextInt();
                int r = in.nextInt();
                int[] counta = new int[26];
                int[] countb = new int[26];
                for(int i=l;i<=r;i++){
                    counta[a.charAt(i-1)-'a']++;
                    countb[b.charAt(i-1)-'a']++;
                }
                int sum = 0;
                for(int i=0;i<26;i++){
                    sum += Math.min(counta[i], countb[i]);
                }
                System.out.println(r-l+1-sum);
            }
        }
    }
}
