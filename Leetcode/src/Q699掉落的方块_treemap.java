import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q699掉落的方块_treemap {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int max_all = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for(int[] pos : positions) {
            int left = pos[0];
            int length = pos[1];

        }
        return ans;
    }
    public static void main(String[] args) {
        Q699掉落的方块_treemap solution = new Q699掉落的方块_treemap();
        System.out.println(solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
    }
} 