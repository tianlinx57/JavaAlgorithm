import java.util.Arrays;
import java.util.HashMap;

public class Q100300所有数对中数位不同之和 {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int m = 0;
        int temp = nums[0];
        while (temp != 0){
            ++m;
            temp /= 10;
        }
        HashMap<Integer,Integer>[] mapList = new HashMap[m];
        Arrays.setAll(mapList,i->new HashMap<>());
        for(int i=0;i<n;i++){
            int weishu = 0;
            int weizhi = 0;
            while(nums[i]!=0){
                weizhi = nums[i]%10;
                nums[i] /= 10;
                mapList[weishu].put(weizhi,mapList[weishu].getOrDefault(weizhi,0)+1);
                ++weishu;
            }
        }

        long ans = 0;
        for(int i=0;i<m;i++){
            int[] values = mapList[i].values().stream().mapToInt(Integer::intValue).toArray();
            int sum = values[0];
            for(int j=1;j < values.length;j++){
                ans += sum*values[j];
                sum += values[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q100300所有数对中数位不同之和 solution = new Q100300所有数对中数位不同之和();
        System.out.println(solution.sumDigitDifferences(new int[]{13,23,12}));

    }
}