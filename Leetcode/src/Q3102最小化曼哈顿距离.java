import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

//给你一个数组 nums ，它是 [0, 1, 2, ..., n - 1] 的一个
// 排列
//  。对于任意一个 [0, 1, 2, ..., n - 1] 的排列 perm ，其 分数 定义为：
//
// score(perm) = |perm[0] - nums[perm[1]]| + |perm[1] - nums[perm[2]]| + ... + |perm[n - 1] - nums[perm[0]]|
//
// 返回具有 最低 分数的排列 perm 。如果存在多个满足题意且分数相等的排列，则返回其中
// 字典序最小
// 的一个。
public class Q3102最小化曼哈顿距离 {
    public int minimumDistance(int[][] points) {
        int n = points.length;
        int[][] distances = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int dis = calculate_distance(points[i], points[j]);
                insert_distance(distances[i], dis);
                insert_distance(distances[j], dis);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(j == i) continue;
                int dis = calculate_distance(points[i], points[j]);
                int max_after = max_after_delete(distances[j],dis);
                // System.out.println(max_after);
                max = Math.max(max_after,max);
            }
            ans = Math.min(ans,max);
        }
        return ans;
    }

    int calculate_distance(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }

    int max_after_delete(int[] a,int dis){
        if(dis == a[0]) return a[1];
        return a[0];
    }

    void insert_distance(int[] a,int dis){
        if(dis > a[0]){
            a[1] = a[0];
            a[0] = dis;
        } else if(dis == a[0]) {
            a[1] = a[0];
        } else if (dis > a[1]) {
            a[1] = dis;
        }
    }

    public static void main(String[] args) {
        Q3102最小化曼哈顿距离 solution = new Q3102最小化曼哈顿距离();
        // System.out.println(solution.minimumDistance(new int[][]{{3,10},{5,15},{10,2},{4,4}}));

        // TreeMap<Integer, String> treeMap = new TreeMap<>();
        // treeMap.put(3, "Three");
        // treeMap.put(1, "One");
        // treeMap.put(4, "Four");
        // treeMap.put(2, "Two");
        //
        // // 按键的自然顺序遍历
        // for (Integer key : treeMap.keySet()) {
        //     System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        // }
        //
        // // 获取第一个和最后一个键
        // System.out.println("First Key: " + treeMap.firstKey());
        // System.out.println("Last Key: " + treeMap.lastKey());

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}