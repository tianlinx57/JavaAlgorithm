import java.math.BigDecimal;

public class week411Q3找出最大的N位K回文数_2 {
    public String largestPalindrome(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if(k==1 || k==3 || k==9){
            for(int i=0;i<n;i++){
                sb.append(9);
            }
            return sb.toString();
        }
        if(k==2){
            if(n==1) return "8";
            sb.append(8);
            sb.append("9".repeat(Math.max(0, n - 2)));
            sb.append(8);
            return sb.toString();
        }
        if(k==4){
            if(n<=4)sb.append("8".repeat(Math.max(0, n)));
            else {
                sb.append(88);
                sb.append("9".repeat(Math.max(0, n - 4)));
                sb.append(88);
            }
            return sb.toString();
        }
        if(k==8){
            if(n<=6)sb.append("8".repeat(Math.max(0, n)));
            else {
                sb.append(888);
                sb.append("9".repeat(Math.max(0, n - 6)));
                sb.append(888);
            }
            return sb.toString();
        }
        if(k==5){
            if(n==1) return "5";
            sb.append(5);
            sb.append("9".repeat(Math.max(0, n - 2)));
            sb.append(5);
            return sb.toString();
        }
        if(k==6){
            if(n==2) return "66";
            if(n==1) return "6";
            sb.append(8);
            sb.append("9".repeat(Math.max(0, n - 2)));
            sb.append(8);
            long sum = 9L *n-2;
            long chaju = sum%3;
            if(n%2==1){
                sb.replace(n/2,n/2+1,9-chaju+"");
            } else {
                sb.replace(n/2-1,n/2+1,"77");
            }
            return sb.toString();
        }
        if(k==7){
            int[] test = new int[]{0,2,1,5,3,4};
            int[] chajuweishu = new int[]{1,3,2,6,4,5};
            if(n==1) return "7";
            sb.append("9".repeat(Math.max(0, n)));
            int chaju = test[n%6];
            if(n%2 == 1){
                int keyimibu = chajuweishu[(n/2)%6]+chajuweishu[(n/2-1)%6];
                int yijingmibu = 0;
                int temp = 9;
                // System.out.println(keyimibu);
                // System.out.println(yijingmibu);
                // System.out.println(chaju);
                while(true){
                    if(yijingmibu == chaju) break;
                    yijingmibu = (yijingmibu+keyimibu)%7;
                    --temp;
                }
                sb.replace(n/2,n/2+1,temp+"");
            }
            if(n%2 == 0){
                int keyimibu = chajuweishu[n/2]+chajuweishu[n/2-1];
                int yijingmibu = 0;
                int temp = 9;
                while(true){
                    if(yijingmibu == chaju) break;
                    yijingmibu = (yijingmibu+keyimibu)%7;
                    --temp;
                }
                sb.replace(n/2,n/2+1,temp+"");
                sb.replace(n/2-1,n/2,temp+"");
            }
            return sb.toString();
        }
        return "";
    }
    public static void main(String[] args) {
        week411Q3找出最大的N位K回文数_2 solution = new week411Q3找出最大的N位K回文数_2();
        // System.out.println(solution.largestPalindrome(3,5));
        // System.out.println(solution.largestPalindrome(7,8));
        System.out.println(solution.largestPalindrome(2,7));
        System.out.println(solution.largestPalindrome(3,7));
        System.out.println(solution.largestPalindrome(4,7));
        System.out.println(solution.largestPalindrome(5,7));
        System.out.println(solution.largestPalindrome(6,7));
        System.out.println();
        // System.out.println(8999779998L%6);
        // System.out.println(8999999998999999998L%6);
        System.out.println(9%7);
        System.out.println(99%7);
        System.out.println(999%7);
        System.out.println(9999%7);
        System.out.println(99999%7);
        System.out.println(999999%7);
        System.out.println(9999999%7);
        System.out.println(99999999%7);
        System.out.println(999999999%7);
        System.out.println(9999999999L%7);
        System.out.println(99999999999L%7);
        System.out.println(999999999999L%7);
        System.out.println(9999999999999L%7);
        System.out.println(99999999999999L%7);
        System.out.println();
        System.out.println(1%7);
        System.out.println(10%7);
        System.out.println(100%7);
        System.out.println(1000%7);
        System.out.println(10000%7);
        System.out.println(100000%7);
        System.out.println(1000000%7);
        System.out.println(10000000%7);
        System.out.println(100000000%7);
        System.out.println(1000000000%7);
    }
}