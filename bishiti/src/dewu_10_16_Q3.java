import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class dewu_10_16_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());
        for(int cc=0;cc<Cases;++cc){
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] chars = new char[n][m];
            String temp = in.nextLine();
            for(int i=0;i<n;++i){
                String s = in.nextLine();
                chars[i] = s.toCharArray();
            }
            String target = in.nextLine();
            // System.out.println(Arrays.deepToString(chars));
            // System.out.println(target);
            HashMap<Character,int[]> hashMap = new HashMap<Character,int[]>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(chars[i][j] != '_'){
                        hashMap.put(chars[i][j],new int[]{i,j});
                    }
                }
            }
            int now_i = 0;
            int now_j = 0;
            int res = 0;
            for(char c:target.toCharArray()){
                int[] pos = hashMap.get(c);
                int next_i = pos[0];
                int next_j = pos[1];
                res += Math.abs(now_i-next_i)+Math.abs(now_j-next_j)+1;
                now_i = next_i;
                now_j = next_j;
            }
            System.out.println(res);
        }
        
    }
}