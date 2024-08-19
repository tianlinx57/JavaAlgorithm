import java.util.ArrayList;
import java.util.List;


public class week33Q2可以到达所有点的最少点数目 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] weather_in = new int[n];
        for(List<Integer> edge : edges){
            int out = edge.get(0);
            int in = edge.get(1);
            weather_in[in] = 1;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(weather_in[i] == 0) {
                res.add(i);
            }
        }
        if(res.isEmpty()){
            res.add(0);
            return res;
        }
        return res;
    }
    public static void main(String[] args) {
        week33Q2可以到达所有点的最少点数目 solution = new week33Q2可以到达所有点的最少点数目();
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(){{add(0);add(1);}});
        edges.add(new ArrayList<>(){{add(0);add(2);}});
        edges.add(new ArrayList<>(){{add(2);add(5);}});
        edges.add(new ArrayList<>(){{add(3);add(4);}});
        edges.add(new ArrayList<>(){{add(4);add(2);}});
        System.out.println(solution.findSmallestSetOfVertices(6,edges));
    }
}