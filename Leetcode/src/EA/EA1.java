package EA;

public class EA1 {

    String checkHuiWen(String s){
        int n = s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        String ans = "";
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                // if(chars[i] == chars[j]){
                    if(check(s.substring(i,j+1))){
                        if(max < j-i+1){
                            max = j-i+1;
                            ans = s.substring(i,j+1);
                        }
                    }
                // }
            }
        }
        return ans;
    }

    boolean check(String s){
        int n = s.length();
        int i=0, j=n-1;
        while (i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        // 预处理
        String t = preprocess(s);
        int n = t.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        int maxLen = 0, centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            if (i < right)
                p[i] = Math.min(right - i, p[mirror]);

            // 尝试扩展回文
            while (t.charAt(i + (1 + p[i])) == t.charAt(i - (1 + p[i])))
                p[i]++;

            // 更新中心和右边界
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // 记录最大长度
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }


    public static void main(String[] args) {
        EA1 solution = new EA1();
        EA2_dp ea2_dp = new EA2_dp();
        EA2_中心拓张 ea2_中心拓张 = new EA2_中心拓张();

        // 生成测试字符串
        String testString = TestStringGenerator.generateRandomString(100000); // 调整长度以增加复杂性

        // // 测试第一个方法
        // long startTime1 = System.nanoTime();
        // String result1 = solution.checkHuiWen(testString);
        // long endTime1 = System.nanoTime();
        // long duration1 = endTime1 - startTime1;

        // 测试第二个方法
        long startTime2 = System.nanoTime();
        String result2 = solution.longestPalindrome(testString);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        // // 输出结果
        // System.out.println("测试字符串长度：" + testString.length());
        // System.out.println("Brute-force 方法找到的最长回文子串长度：" + result1.length());
        // System.out.println("Brute-force 方法耗时：" + duration1 / 1_000_000.0 + " 毫秒");

        System.out.println("Manacher's 方法找到的最长回文子串长度：" + result2.length());
        System.out.println("Manacher's 方法耗时：" + duration2 / 1_000_000.0 + " 毫秒");


        // // 测试第3个方法
        // startTime2 = System.nanoTime();
        // result2 = ea2_dp.longestPalindrome(testString);
        // endTime2 = System.nanoTime();
        // duration2 = endTime2 - startTime2;
        //
        //
        // System.out.println("EA2_dp 方法找到的最长回文子串长度：" + result2.length());
        // System.out.println("EA2_dp 方法耗时：" + duration2 / 1_000_000.0 + " 毫秒");

        // 测试第4个方法
        startTime2 = System.nanoTime();
        result2 = ea2_中心拓张.longestPalindrome(testString);
        endTime2 = System.nanoTime();
        duration2 = endTime2 - startTime2;
        System.out.println(result2);


        System.out.println("EA2_中心拓张 方法找到的最长回文子串长度：" + result2.length());
        System.out.println("EA2_中心拓张 方法耗时：" + duration2 / 1_000_000.0 + " 毫秒");
    }
}