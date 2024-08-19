import java.util.HashMap;
import java.util.Map;

class zuixiao_haojinzhi {
    public String smallestGoodBase(String n) {
        long flag = 0;
        long nVal = Long.parseLong(n);
        long intValue = 0;
        long mMax = (long) Math.floor(Math.log(nVal) / Math.log(2));
        while (mMax > 1 && flag == 0){
//            double result = Math.pow(nVal, 1.0 / mMax);
//            intValue = (long) Math.ceil(result)-1;
            intValue = (long)Math.pow(nVal, 1.0 / mMax);
//            System.out.println(intValue);
            long sum = 0;
            for (long i = 0; i <= mMax; i++) {
                long temp = 1;
                for(long j = 0; j < i;j++){
                    temp *= intValue;
                }
                sum += temp;
            }
//            System.out.println(sum+"和"+nVal);
            if(sum == nVal){
                flag = 1;
            }
            mMax--;
//            System.out.println(mMax);
        }
        if(flag == 0){return Long.toString(nVal-1);}
        return Long.toString(intValue);
    }



    public static void main(String[] args) {
        zuixiao_haojinzhi solution = new zuixiao_haojinzhi();
        System.out.println(solution.smallestGoodBase("13"));// 输出 3
        System.out.println(solution.smallestGoodBase("4681")); // 输出 8
        System.out.println(solution.smallestGoodBase("1000000000000000000")); // 输出 9999
        System.out.println(solution.smallestGoodBase("470988884881403701")); // 输出 686286299
        System.out.println(solution.smallestGoodBase("821424692950225218")); // 输出 821424692950225217
    }
}
