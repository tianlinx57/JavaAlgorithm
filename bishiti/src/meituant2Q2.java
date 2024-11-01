import java.util.HashMap;
import java.util.Scanner;

public class meituant2Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int[] edges = new int[n];
            ++edges[0];
            for(int i=0;i<n-1;i++){
                int x = in.nextInt();
                int j = in.nextInt();
                edges[x-1]++;
                edges[j-1]++;
            }
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<n;i++){
                map.put(edges[i], map.getOrDefault(edges[i], 0)+1);
            }
            // System.out.println(map);
            int sum = 0;
            for(int i:map.keySet()){
                sum += map.get(i)*(map.get(i)-1)/2;
            }
            System.out.println(sum);
        }
    }
}
