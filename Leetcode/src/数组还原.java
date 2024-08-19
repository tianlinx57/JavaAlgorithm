import java.util.*;

public class 数组还原 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] b = new long[n-1];
        long[] c = new long[n-1];

        for(int i=0;i<n-1;i++){
            b[i] = in.nextLong();
        }
        for(int i=0;i<n-1;i++){
            c[i] = in.nextLong();
        }
        Arrays.sort(b);
        Arrays.sort(c);
        for(int i=n-2;i>=1;i--){
            b[i] = b[i]-b[i-1];
        }
        for(int i=n-2;i>=1;i--){
            c[i] = c[i]-c[i-1];
        }

        List<Long> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (!(i==n-1||j==n-1)){
            if(b[i]==c[j]){
                ans.add(b[i]);
                ++i;
                ++j;
                continue;
            }

            if(b[i+1] == c[j]){
                ans.add(b[i]);
                ++i;
                continue;
            }

            ans.add(c[j]);
            ++j;
        }
        if(i == n-2){
            ans.add(b[i]);
        }
        if(j == n-2){
            ans.add(c[j]);
        }

        for(int k=0;k<ans.size();k++){
            System.out.print(ans.get(k));
            System.out.print(' ');
        }
    }
}
