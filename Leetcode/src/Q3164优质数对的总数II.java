import java.util.HashMap;

public class Q3164优质数对的总数II {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;


        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums1[i] % k !=0){
                continue;
            } else {
                nums1[i] /= k;
            }

            int sqrt = (int)Math.sqrt(nums1[i]);
            for(int j=1;j<=sqrt;j++){
                if(nums1[i] % j == 0){
                    hashMap.put(j,hashMap.getOrDefault(j,0)+1);
                    if(j*j != nums1[i]){
                        hashMap.put(nums1[i] / j,hashMap.getOrDefault(nums1[i] / j,0)+1);
                    }
                }
            }
            // System.out.println(hashMap);
        }


        long ans = 0;
        for(int i=0;i<m;i++){
            if(hashMap.containsKey(nums2[i])){
                ans += hashMap.get(nums2[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3164优质数对的总数II solution = new Q3164优质数对的总数II();
        // System.out.println(solution.waysToReachStair(0));
        // System.out.println(solution.waysToReachStair(1));
        // System.out.println(solution.numberOfPairs(new int[]{1,2,4,12},new int[]{2,4},3));
        System.out.println(solution.numberOfPairs(new int[]{1,3,4},new int[]{1,3,4},1));
    }
}