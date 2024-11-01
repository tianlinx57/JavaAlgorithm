import java.util.*;

//并查集
public class Q15三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        // int n = nums.length;
        // Set<List<Integer>> ans = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = i+1; j < n; j++) {
        //         for (int k = j+1; k < n; k++) {
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 int finalI = i;
        //                 int finalJ = j;
        //                 int finalK = k;
        //                 int[] temp = new int[]{
        //                         nums[finalI],
        //                         nums[finalJ],
        //                         nums[finalK]
        //                 };
        //                 Arrays.sort(temp);
        //                 ans.add(new ArrayList<>(){{
        //                     add(temp[0]);
        //                     add(temp[1]);
        //                     add(temp[2]);}});
        //             }
        //         }
        //     }
        // }
        // return ans.stream().toList();

        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i:nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        for(int i=0;i<n-2;++i){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j=i+1;
            if(-(nums[i]+nums[j])<nums[j])break;
            while (j<n-1){
                if(-(nums[i]+nums[j])<nums[j]) {
                    ++j;
                    continue;
                }
                if(hashMap.containsKey(-(nums[i]+nums[j]))){
                    HashMap<Integer,Integer> temp = new HashMap<>();
                    for(int x: new int[]{nums[i],nums[j],-(nums[i]+nums[j])}){
                        temp.put(x,temp.getOrDefault(x,0)+1);
                    }
                    int flag = 0 ;
                    for(int key:temp.keySet()){
                        if(temp.get(key) > hashMap.get(key)) flag = 1;
                    }
                    if(flag==0){
                        int finalI = i;
                        int finalJ = j;
                        ans.add(new ArrayList<>(){{
                            add(nums[finalI]);
                            add(nums[finalJ]);
                            add(-(nums[finalI]+nums[finalJ]));
                        }});
                    }
                }
                while (j<n-1){
                    ++j;
                    if(nums[j] != nums[j-1]){
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Q15三数之和 solution = new Q15三数之和();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}