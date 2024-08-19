import java.util.*;

public class CF1998C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int k = in.nextInt();//k表示可以进行的增加次数
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
            }
            int count0 = 0;
            for(int i=0;i<n;i++){
                b[i] = in.nextInt();
                if(b[i]==0) count0++;
            }
            int[] zeros = new int[count0];
            int[] ones = new int[n-count0];

            int index0 = 0;
            int index1 = 0;
            for(int i=0;i<n;i++){
                if(b[i]==0) zeros[index0++] = a[i];
                else ones[index1++] = a[i];
            }
            Arrays.sort(zeros);
            Arrays.sort(ones);
            int max0 = zeros[count0-1];
            int max1 = ones[n-count0-1];

            int ans = max1+k+zeros[(count0+1)/2];
            if(max0 > max1){
                int i = (n-count0+1)/2;
                int count = 1;
                int mid = ones[i];
                while (true) {
                    int chaju = ones[i+1] - mid;
                    if(chaju*count <= k){
                        mid += k/count;
                        break;
                    }else{
                        mid = ones[i+1];
                        k -= chaju*count;
                        i++;
                        count++;
                    }
                }
                ans = Math.max(ans, mid+max0);
            }
            System.out.println(ans);
        }
    }
}
