import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

//并查集
public class 网易雷火Q2 {
    static long solve(int a,int b){

        a++;
        b++;
        int gcd = gcd(a,b);
        a/=gcd;
        b/=gcd;

        // double now = 0;
        // double next = (double) b /a;
        double index = (double) b /a;

        long ans = 0;
        for(int i=0;i<a;++i){
            // ans += (int)next-(int)now+1;
            // // System.out.println(ans);
            // now = next;
            // next += (double) b /a;
            double now = index*i;
            double next = index*(i+1);
            ans += (int)next-(int)now+1;
        }
        --ans;
        ans*=gcd;
        return ans;
    }


    public static int gcd(int a, int b) {// 辗转相除法 改进,调用函数递归
        return (a % b == 0) ? b : gcd(b, a % b);// 相同思路,三元运算/简化写法
    }

    public static void main(String[] args) {
        网易雷火Q2 solution = new 网易雷火Q2();
        System.out.println(solution.solve(3,2));
        System.out.println(solution.solve(2,2));
        System.out.println(solution.solve(10,10));
        System.out.println(solution.solve(9,100));
        System.out.println(solution.solve(99999,1000001));

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Apple");
        treeMap.put(3, "Banana");
        treeMap.put(2, "Cherry");

        // 顺序输出 value
        System.out.println("按键的顺序输出:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        // 逆序输出 value
        System.out.println("按键的逆序输出:");
        for (Map.Entry<Integer, String> entry : treeMap.descendingMap().entrySet()) {
            System.out.println(entry.getValue());
        }
        // 逆序输出 value
        System.out.println("按键的逆序输出:");
        for (Integer entry : treeMap.descendingKeySet()) {
            System.out.println(treeMap.get(entry));
        }
        System.out.println("按键的逆序输出:");
        for (Integer entry : treeMap.sequencedKeySet()) {
            System.out.println(treeMap.get(entry));
        }

    }
}