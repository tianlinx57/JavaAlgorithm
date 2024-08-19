import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//没做出
public class Q2812找出最安全路径 {
    int[] direction = new int[]{0,-1,0,1,0};
    List<List<Integer>> grid;
    int n;
    int[][] visited;
    int[][] memo;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.grid = grid;
        init_grid();
        // System.out.println(this.grid);
        // System.out.println(grid);
        int k = search();
        return k-1;
    }
    int search(){
        int left = 1,right = n;
        while(left<right){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    memo[i][j] = -1;
                }
            }
            int mid = (left+right+1)/2;
            // System.out.println(mid);
            if(check(mid,0,0)){
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    boolean check(int k,int x,int y){
        if(memo[x][y] != -1) return memo[x][y]==1;
        if(grid.get(x).get(y)<k) return false;
        if(x==n-1&&y==n-1) return true;
        visited[x][y] = 1;
        boolean ok = false;
        for(int i=0;i<4;i++){
            int new_x = x+direction[i];
            int new_y = y+direction[i+1];
            if(new_x<0||new_x>=n||new_y<0||new_y>=n) continue;
            if(visited[new_x][new_y] == 1) continue;
            if(grid.get(new_x).get(new_y)>=k) ok |=  check(k,new_x,new_y);
        }
        visited[x][y]=0;
        memo[x][y] = ok?1:0;
        // System.out.println(x+" "+y+" "+ok);
        // System.out.println();
        return ok;
    }
    void init_grid(){
        this.n = grid.size();
        visited = new int[n][n];
        memo = new int[n][n];
        Deque<int[]> deque = new ArrayDeque<>();//int[] 0表示x 1表示y 2表示distance
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int distance = grid.get(i).get(j);
                if(distance == 0) continue;
                for(int k=0;k<4;k++){
                    int new_x = i + direction[k];
                    int new_y = j + direction[k+1];
                    if(new_x<0||new_x>=n||new_y<0||new_y>=n) continue;
                    if(grid.get(new_x).get(new_y) != 0) continue;
                    deque.add(new int[]{new_x,new_y,distance+1});
                }
            }
        }
        while (!deque.isEmpty()){
            int[] temp = deque.removeFirst();
            int x = temp[0];
            int y = temp[1];
            int distance = temp[2];
            if(grid.get(x).get(y) != 0) continue;
            grid.get(x).set(y,distance);
            for(int k=0;k<4;k++){
                int new_x = x + direction[k];
                int new_y = y + direction[k+1];
                if(new_x<0||new_x>=n||new_y<0||new_y>=n) continue;
                if(grid.get(new_x).get(new_y) != 0) continue;
                deque.add(new int[]{new_x,new_y,distance+1});
            }
        }
    }
    public static void main(String[] args) {
        Q2812找出最安全路径 solution = new Q2812找出最安全路径();
        List<List<Integer>> grid = new ArrayList<>();
        // grid.add(new ArrayList<>(){{add(1);add(0);add(0);}});
        // grid.add(new ArrayList<>(){{add(0);add(0);add(0);}});
        // grid.add(new ArrayList<>(){{add(0);add(0);add(1);}});
        grid.add(new ArrayList<>(){{add(0);add(0);add(1);}});
        grid.add(new ArrayList<>(){{add(0);add(0);add(0);}});
        grid.add(new ArrayList<>(){{add(0);add(0);add(0);}});
        // System.out.println(grid);
        System.out.println(solution.maximumSafenessFactor(grid));
    }
}