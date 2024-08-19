import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class HashTableExample {

    public static void main(String[] args) {
        // 创建一个 HashMap 实例
        Map<String, Integer> map = new HashMap<>();

        // 添加元素到哈希表
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // 访问元素
        System.out.println("元素 One 的值: " + map.get("One"));

        // 移除元素
        map.remove("Two");

        // 遍历 HashMap
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println("键: " + entry.getKey() + ", 值: " + entry.getValue());
        }


        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出 true

        Float i11 = 333f;
        Float i22 = 333f;
        System.out.println(i11 == i22);// 输出 false

        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出 false



        float aa = 2.0f - 1.9f;
        float bb = 1.8f - 1.7f;
        System.out.println(aa);// 0.100000024
        System.out.println(bb);// 0.099999905
        System.out.println(aa == bb);// false


        System.out.println();
//        BigDecimal a = new BigDecimal("1.0");
//        BigDecimal b = new BigDecimal("0.9");
//        System.out.println(a.add(b));// 1.9
//        System.out.println(a.subtract(b));// 0.1
//        System.out.println(a.multiply(b));// 0.90
//        System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
//        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11



        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);

        for (String item : list) {
            System.out.println(item);
        }



    }
}
