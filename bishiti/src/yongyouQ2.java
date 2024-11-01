import java.util.*;

public class yongyouQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] nums = new int[n];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0)+1);
        }
        Integer[] number = hashMap.keySet().toArray(new Integer[0]);
        Arrays.sort(number);
        // System.out.println(Arrays.toString(number));

        int ans = 0;
        for(int i=0;i<number.length;i++){
            for(int j=i;j<number.length;j++){
                int z = sum-number[i]-number[j];
                if(z < number[j]) break;
                if(hashMap.containsKey(z)){
                    // System.out.println(number[i]);
                    // System.out.println(number[j]);
                    // System.out.println(z);
                    // System.out.println(ans);
                    // System.out.println();
                    
                    if(i == j && number[i] == z){
                        if(hashMap.get(number[i])<=2) continue;
                        ans += hashMap.get(number[i])*(hashMap.get(number[i])-1)*(hashMap.get(number[i])-2)/6;
                        continue;
                    }
                    if(i==j){
                        // System.out.println(hashMap.get(number[i]));
                        // System.out.println(hashMap.get(z));
                        ans += hashMap.get(number[i])*(hashMap.get(number[i])-1)/2*hashMap.get(z);
                        continue;
                    }
                    // if(number[i] == z){
                    //     ans += hashMap.get(number[i])*(hashMap.get(number[i])-1)/2*hashMap.get(number[j]);
                    //     continue;
                    // }
                    if(number[j] == z){
                        ans += hashMap.get(number[j])*(hashMap.get(number[j])-1)/2*hashMap.get(number[i]);
                        continue;
                    }
                    ans += hashMap.get(number[i])*hashMap.get(number[j])*hashMap.get(z);
                    
                }
            }
        }
        System.out.println(ans);
    }
}
