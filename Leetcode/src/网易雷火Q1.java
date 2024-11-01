import java.util.ArrayList;
import java.util.Objects;

//并查集
public class 网易雷火Q1 {
    public ArrayList<ArrayList<Long>> diff (ArrayList<Long> leftIds, ArrayList<String> leftValues, ArrayList<Long> rightIds, ArrayList<String> rightValues) {
        int n1 = leftIds.size();
        int n2 = rightIds.size();


        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        //0为新增 1为修改 2为删除
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        int i=0,j=0;
        while (i<n1 && j<n2) {
            long leftid = leftIds.get(i);
            long rightid = rightIds.get(j);
            String leftvalue = leftValues.get(i);
            String rightvalue = rightValues.get(j);
            if(leftid<rightid){
                ans.get(2).add(leftid);
                ++i;
                continue;
            }
            if(leftid>rightid){
                ans.get(0).add(rightid);
                ++j;
                continue;
            }
            if(!leftvalue.equals(rightvalue)){
                ans.get(1).add(leftid);
            }
            ++i;
            ++j;
        }
        if(i==n1){
            while (j<n2){
                long rightid = rightIds.get(j);
                ans.get(0).add(rightid);
                ++j;
            }
        }
        if(j==n2){
            while (i<n1){
                long leftid = leftIds.get(i);
                ans.get(2).add(leftid);
                ++i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        网易雷火Q1 solution = new 网易雷火Q1();
        ArrayList<Long> long1 = new ArrayList<>();
        long1.add(1L);
        long1.add(2L);
        ArrayList<Long> long2 = new ArrayList<>();
        long2.add(1L);
        long2.add(2L);
        ArrayList<String> stirng1 = new ArrayList<>();
        stirng1.add("newcoder");
        stirng1.add("best");
        ArrayList<String> stirng2 = new ArrayList<>();
        stirng2.add("newcoder");
        stirng2.add("great");

        System.out.println(solution.diff(long1,stirng1,long2,stirng2));

        Integer i = null;
        Integer i2 = 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(i);
        arrayList.add(i2);
        System.out.println(arrayList);
    }
}