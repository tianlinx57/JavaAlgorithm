import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class vivoQ2 {

    public int[] findFluctuations (int[] memoryUsage, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<k;++i){
            treeSet.add(memoryUsage[i]);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(treeSet.getLast()-treeSet.getFirst());
        int n = memoryUsage.length;
        for(int i=k;i<n;++i){
            treeSet.remove(memoryUsage[i-k]);
            treeSet.add(memoryUsage[i]);
            ans.add(treeSet.getLast()-treeSet.getFirst());
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        vivoQ2 solution = new vivoQ2();
        System.out.println(Arrays.toString(solution.findFluctuations(new int[]{80, 100, 70, 90, 60, 85, 75, 95, 110}, 4)));

    }
}