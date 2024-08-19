import java.util.HashMap;
import java.util.Scanner;

public class CF1994C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> newHashMap = new HashMap<Integer,Integer>();
            int n = in.nextInt();
            int max = in.nextInt();
            long ans = 0;
            for(int i = 0;i<n;i++){
                hashMap.put(0,1+hashMap.getOrDefault(0,0));
                int num = in.nextInt();
                for(int key : hashMap.keySet()){
                    int temp = 0; // 表示经过这个点后的值
                    int value = hashMap.get(key);
                    if(key+num > max){
                        temp = 0;
                    }else{
                        temp = key+num;
                        ans += value;
                    }
                    
                    newHashMap.put(temp, value+newHashMap.getOrDefault(temp,0));
                }
                hashMap = newHashMap;
                newHashMap = new HashMap<>();
                // System.out.println(Cases);
                // System.out.println(hashMap);
                // System.out.println(newHashMap);
                // System.out.println();
            }
            System.out.println(ans);
        }
    }
}
