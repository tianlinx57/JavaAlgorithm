// package c198;

//
// Codeforces Round (Div. 2) 2024-07-15 07:35
// E. Range Minimum Sum
// https://codeforces.com/contest/1988/problem/E
// time limit per test 4 seconds; memory limit per test 512 megabytes
// public class Pseudo for 'Source should satisfy regex [^{}]*public\s+(final)?\s*class\s+(\w+).*'
//
// For an array [a_1,a_2,...,a_n] of length n, define f(a) as the sum of the minimum element over
// all subsegments. That is, f(a)=\sum_{l=1}^n\sum_{r=l}^n \min_{l<= i<= r}a_i.
//
// A permutation is a sequence of integers from 1 to n of length n containing each number exactly
// once. You are given a permutation [a_1,a_2,...,a_n]. For each i, solve the following problem
// independently:
//  * Erase a_i from a, concatenating the remaining parts, resulting in b =
//    [a_1,a_2,...,a_{i-1},\;a_{i+1},...,a_{n}].
//  * Calculate f(b).
//
// Input
//
// Each test contains multiple test cases. The first line contains the number of test cases t (1 <=
// t <= 10^5). Description of the test cases follows.
//
// The first line of each test case contains an integer n (1<= n<= 5* 10^5).
//
// The second line of each test case contains n distinct integers a_1,...,a_n (1<= a_i<= n).
//
// It is guaranteed that the sum of n over all test cases does not exceed 10^6.
//
// Output
//
// For each test case, print one line containing n integers. The i-th integer should be the answer
// when erasing a_i.
//
// Example
/*
input:
4
1
1
3
3 1 2
5
4 2 1 5 3
8
8 1 4 6 7 3 5 2

output:

0
4 7 5
19 21 27 17 19
79 100 72 68 67 80 73 80
*/
// Note
//
// In the second test case, a=[3,1,2].
//  * When removing a_1, b=[1,2]. S(b)=1+2+\min{1,2}=4.
//  * When removing a_2, b=[3,2]. S(b)=3+2+\min{3,2}=7.
//  * When removing a_3, b=[3,1]. S(b)=3+1+\min{3,1}=5.
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C1988E {
    static final int MOD = 998244353;
    static final Random RAND = new Random();

    static long[] solve(int[] a) {
        int n = a.length;
        long[] ans = new long[n];
        if (n == 1) {
            return ans;
        }

        int[] la = computeLeft(a);
        int[] ra = computeRight(a);
        int[] lla = computeLeftLeft(a, la);
        int[] rra = computeRightRight(a, ra);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long x = 1L * a[i] * (i - la[i]) * (ra[i] - i);
            if (test) System.out.format("  i:%d x:%d\n", i, x);
            sum += x;
        }
        if (test) System.out.format("    a:%s\n", trace(a));
        if (test) System.out.format("   la:%s\n", trace(la));
        if (test) System.out.format("   ra:%s\n", trace(ra));
        if (test) System.out.format("  sum:%d\n", sum);

        Arrays.fill(ans, sum);

        long[] inc = new long[n+1];

        for (int i = 0; i < n; i++) {
            // If we remove a[i].
            int v = a[i];
            int l = la[i];
            int r = ra[i];
            ans[i] -= 1L * v * (i - l) * (r - i);

            //  . . o * * * * v * * * * o
            //      ^         ^         ^
            //      l         i         r

            // For any index j in [l+1, i-1], removing a[j] will decrease left of i by 1
            // and hence decrease the contribution of a[i]
            if (l+1 <= i-1) {
                long x = 1L * (r - i) * v;
                inc[l+1] -= x;
                inc[i] += x;
            }
            if (i + 1 <= r - 1) {
                long x = 1L * (i - l) * v;
                inc[i+1] -= x;
                inc[r] += x;
            }

            {
                // If a[l] is removed, la[i] might decrease to j1
                if (l > 0) {
                    int j1 = lla[i];
                    int k = l - j1 - 1;
                    ans[l] += 1L * k * (r - i) * v;
                }
            }
            {
                if (r < n-1) {
                    int j1 = rra[i];
                    int k = j1 - r - 1;
                    ans[r] += 1L * k * (i - l) * v;
                }
            }
        }

        for (int i = 1; i < inc.length; i++) {
            inc[i] += inc[i-1];
        }
        if (test) System.out.format("  ans:%s\n", trace(ans));
        if (test) System.out.format("  inc:%s\n", trace(inc));
        for (int i = 0; i < n; i++) {
            ans[i] += inc[i];
        }
        return ans;
    }

    static int[] computeLeftLeft(int[] a, int[] la) {
        int n = a.length;
        int[] lla = new int[n];
        Arrays.fill(lla, -1);

        List<Integer>[] lidxes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int l = la[i];
            if (l < 0) {
                continue;
            }
            if (lidxes[l] == null) {
                lidxes[l] = new ArrayList<>();
            }
            lidxes[l].add(i);
        }
        // Map from v to the largest index (before current) i such that a[i] <= v
        TreeMap<Integer, Integer> vim = new TreeMap<>();
        vim.put(-1, -1);
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (lidxes[i] != null) {
                for (int idx : lidxes[i]) {
                    int w = a[idx];
                    // we want the largest index with value < w
                    lla[idx] = vim.floorEntry(w-1).getValue();
                }
            }
            // add (v, i) into vim. Ensure the bigger v, the bigger i.
            while (!vim.isEmpty() && vim.lastKey() > v) {
                vim.remove(vim.lastKey());
            }
            vim.put(v, i);
        }
        return lla;
    }

    static int[] computeRightRight(int[] a, int[] ra) {
        int n = a.length;
        int[] rra = new int[n];
        Arrays.fill(rra, n);

        List<Integer>[] ridxes = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            int r = ra[i];
            if (r >= n) {
                continue;
            }
            if (ridxes[r] == null) {
                ridxes[r] = new ArrayList<>();
            }
            ridxes[r].add(i);
        }
        // Map from v to the smallest index (after current) i such that a[i] <= v
        TreeMap<Integer, Integer> vim = new TreeMap<>();
        vim.put(-1, n);
        for (int i = n-1; i >= 0; i--) {
            int v = a[i];
            if (ridxes[i] != null) {
                for (int idx : ridxes[i]) {
                    int w = a[idx];
                    // we want the largest index with value < w
                    rra[idx] = vim.floorEntry(w-1).getValue();
                }
            }
            // add (v, i) into vim. Ensure the bigger v, the bigger i.
            while (!vim.isEmpty() && vim.lastKey() > v) {
                vim.remove(vim.lastKey());
            }
            vim.put(v, i);
        }
        return rra;
    }

    // Time limit exceeded on test 5
    // 1
    // 500000
    // 2 1 4 3 6 5 8 7 10 9 12 11 14 13 16 15 18 17 20 19 22 21 ...
    static long[] solveB(int[] a) {
        int n = a.length;
        long[] ans = new long[n];
        if (n == 1) {
            return ans;
        }

        int[] la = computeLeft(a);
        int[] ra = computeRight(a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long x = 1L * a[i] * (i - la[i]) * (ra[i] - i);
            if (test) System.out.format("  i:%d x:%d\n", i, x);
            sum += x;
        }
        if (test) System.out.format("    a:%s\n", trace(a));
        if (test) System.out.format("   la:%s\n", trace(la));
        if (test) System.out.format("   ra:%s\n", trace(ra));
        if (test) System.out.format("  sum:%d\n", sum);

        Arrays.fill(ans, sum);

        long[] inc = new long[n+1];

        for (int i = 0; i < n; i++) {
            // If we remove a[i].
            int v = a[i];
            int l = la[i];
            int r = ra[i];
            ans[i] -= 1L * v * (i - l) * (r - i);

            //  . . o * * * * v * * * * o
            //      ^         ^         ^
            //      l         i         r

            // For any index j in [l+1, i-1], removing a[j] will decrease left of i by 1
            // and hence decrease the contribution of a[i]
            if (l+1 <= i-1) {
                long x = 1L * (r - i) * v;
                inc[l+1] -= x;
                inc[i] += x;
            }
            if (i + 1 <= r - 1) {
                long x = 1L * (i - l) * v;
                inc[i+1] -= x;
                inc[r] += x;
            }

            {
                // If a[l] is removed, la[i] might decrease to j1
                if (l > 0) {
                    int j1 = l - 1;
                    while (j1 >= 0 && a[j1] > v) {
                        j1--;
                    }
                    int k = l - j1 - 1;
                    ans[l] += 1L * k * (r - i) * v;
                }
            }
            {
                if (r < n-1) {
                    int j1 = r + 1;
                    while (j1 < n && a[j1] > v) {
                        j1++;
                    }
                    int k = j1 - r - 1;
                    ans[r] += 1L * k * (i - l) * v;
                }
            }
        }

        for (int i = 1; i < inc.length; i++) {
            inc[i] += inc[i-1];
        }
        if (test) System.out.format("  ans:%s\n", trace(ans));
        if (test) System.out.format("  inc:%s\n", trace(inc));
        for (int i = 0; i < n; i++) {
            ans[i] += inc[i];
        }
        return ans;
    }


    // Time limit exceeded on test 3
    // 2
    // 500000
    // 431681 495417 229573 307176 71470 411404 321323 ...
    static long[] solveA(int[] a) {
        int n = a.length;
        long[] ans = new long[n];
        if (n == 1) {
            return ans;
        }

        int[] la = computeLeft(a);
        int[] ra = computeRight(a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long x = 1L * a[i] * (i - la[i]) * (ra[i] - i);
            if (test) System.out.format("  i:%d x:%d\n", i, x);
            sum += x;
        }
        if (test) System.out.format("    a:%s\n", trace(a));
        if (test) System.out.format("   la:%s\n", trace(la));
        if (test) System.out.format("   ra:%s\n", trace(ra));
        if (test) System.out.format("  sum:%d\n", sum);

        Arrays.fill(ans, sum);

        for (int i = 0; i < n; i++) {
            // If we remove a[i].
            int v = a[i];
            int l = la[i];
            int r = ra[i];
            ans[i] -= 1L * v * (i - l) * (r - i);

            {
                // If a[l] is removed, la[i] might decrease to j1
                if (l > 0) {
                    int j1 = l - 1;
                    while (j1 >= 0 && a[j1] > v) {
                        j1--;
                    }
                    int k = l - j1 - 1;
                    ans[l] += 1L * k * (r - i) * v;
                }
            }
            {
                if (r < n-1) {
                    int j1 = r + 1;
                    while (j1 < n && a[j1] > v) {
                        j1++;
                    }
                    int k = j1 - r - 1;
                    ans[r] += 1L * k * (i - l) * v;
                }
            }

            for (int j = i + 1; j < n; j++) {
                int w = a[j];
                if (la[j] < i) {
                    // There is one less item in the left side of a[j]
                    ans[i] -= 1L * (ra[j] - j) * w;
                }
            }
            for (int j = 0; j < i; j++) {
                int w = a[j];
                if (ra[j] > i) {
                    // There is one less item in the right side of a[j]
                    ans[i] -= 1L * (j - la[j]) * w;
                }
            }
        }
        return ans;
    }

    // Time limit exceeded on test 2
    // 100000
    // 6
    // 3 5 1 6 4 2
    // ...
    static long[] solveNaive(int[] a) {
        int n = a.length;
        long[] ans = new long[n];
        if (n == 1) {
            return ans;
        }

        int[] arr = new int[n-1];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                arr[i-1] = a[i-1];
            }
            for (int j = i + 1; j < n; j++) {
                arr[j-1] = a[j];
            }
            // if (test) System.out.format("  i:%d arr:%s\n", i, trace(arr));
            ans[i] = funcEx(arr);
        }
        return ans;
    }

    static int[] computeLeft(int[] a) {
        int n = a.length;
        // la[i] is largest index j < i such that a[j] < a[i]
        int[] la = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            la[i] = s.isEmpty() ? -1 : s.peek();
            s.add(i);
        }
        return la;
    }

    static int[] computeRight(int[] a) {
        int n = a.length;
        Stack<Integer> s = new Stack<>();
        int[] ra = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            ra[i] = s.isEmpty() ? n : s.peek();
            s.add(i);
        }
        return ra;
    }

    static long funcEx(int[] a) {
        int n = a.length;
        // la[i] is largest index j < i such that a[j] < a[i]
        int[] la = computeLeft(a);
        int[] ra = computeRight(a);

        // if (test) System.out.format("  a:%s\n", trace(a));
        // if (test) System.out.format("  l:%s\n", trace(la));
        // if (test) System.out.format("  r:%s\n", trace(ra));

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 1L * a[i] * (i - la[i]) * (ra[i] - i);
        }
        return ans;
    }

    static long[] solveNaiveNaive(int[] a) {
        int n = a.length;
        long[] ans = new long[n];
        if (n == 1) {
            return ans;
        }

        int[] arr = new int[n-1];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                arr[i-1] = a[i-1];
            }
            for (int j = i + 1; j < n; j++) {
                arr[j-1] = a[j];
            }
            // if (test) System.out.format("  i:%d arr:%s\n", i, trace(arr));
            ans[i] = func(arr);
        }
        return ans;
    }

    static long func(int[] a) {
        return func(a, 0, a.length);
    }

    static long func(int[] a, int ib, int ie) {
        if (ib >= ie) {
            return 0;
        }
        if (ib + 1 == ie) {
            return a[ib];
        }
        int mini = ib;
        for (int i = ib + 1; i < ie; i++) {
            if (a[i] < a[mini]) {
                mini = i;
            }
        }
        int l = mini -ib + 1;
        int r = ie - mini;
        long ans = 1L * l * r * a[mini];
        ans += func(a, ib, mini);
        ans += func(a, mini+1, ie);
        return ans;
    }

    static int[] getRandomPerm(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums.get(i);
        }
        return ans;
    }

    static void test(int[] a) {
        System.out.format("test(new int[] %s);\n", trace(a));
        long[] ans = solve(a);
        long[] exp = solveNaive(a);
        boolean ok = true;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != exp[i]) {
                ok = false;
            }
        }
        System.out.format("%s => %s %s\n", trace(a), trace(ans), ok ? "":"Expected " + trace(exp));
        myAssert(ok);
    }

    static boolean test = true;
    static void doTest() {
        if (!test) {
            return;
        }
        long t0 = System.currentTimeMillis();
        test(new int[] {4,2,1,5,3});
        // System.exit(0);

        test(new int[] {1});
        test(new int[] {3,1,2});
        test(new int[] {4,2,1,5,3});
        test(new int[] {8,1,4,6,7,3,5,2});
        test(new int[] {3,5,1,6,4,2});
        test(new int[] {2,1,4,3});
        test(new int[] {1});
        test(new int[] {7,13,4,8,10,2,3,14,6,9,16,15,5,1,11,12});
        test(new int[] {6,2,8,3,1,4,5,7});
        test(new int[] {1,6,5,4,2,3});
        test(new int[] {4,5,7,9,3,6,1,2,8});
        test(new int[] {18,4,8,16,10,3,14,2,17,9,15,13,6,1,7,5,12,11});
        test(new int[] {8,5,3,2,7,1,9,6,10,4});
        test(new int[] {1});
        test(new int[] {3,9,2,7,8,6,5,4,1});
        test(new int[] {5,4,11,8,6,17,13,7,18,10,1,9,2,12,16,14,15,3});
        test(new int[] {2,1});
        test(new int[] {15,16,5,8,13,17,14,18,12,1,3,11,4,2,6,9,7,10});
        test(new int[] {12,2,14,9,5,6,4,11,10,7,1,8,15,13,16,3});
        test(new int[] {1,4,3,2,8,7,5,6});
        test(new int[] {5,1,3,7,2,6,4});
        test(new int[] {17,8,18,15,1,6,5,10,9,2,16,13,4,14,11,7,3,12});
        for (int t = 0; t < 20; t++) {
            int n = 1 + RAND.nextInt(9);
            int[] a = getRandomPerm(n);
            test(a);
        }
        System.out.format("%d msec\n", System.currentTimeMillis() - t0);
        System.exit(0);
    }

    public static void main(String[] args) {
        doTest();
        MyScanner in = new MyScanner();
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int[] a = in.nextIntArr(n);
            // System.out.format("test(new int[] %s);\n", trace(a));
            long[] ans = solve(a);
            output(ans);
        }
    }

    static void output(long[] a) {
        StringBuilder sb = new StringBuilder();
        for (long v : a) {
            sb.append(v);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }

    static void myAssert(boolean cond) {
        if (!cond) {
            throw new RuntimeException("Unexpected");
        }
    }

    static String trace(int[][] a) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append('{');
            for (int j = 0; j < a[i].length; j++) {
                if (j > 0) {
                    sb.append(',');
                }
                sb.append(a[i][j]);

            }
            sb.append('}');
        }
        sb.append('}');
        return sb.toString();
    }

    static String trace(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int v : a) {
            if (sb.length() > 1) {
                sb.append(',');
            }
            sb.append(v);
        }
        sb.append('}');
        return sb.toString();
    }

    static String trace(long[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (long v : a) {
            if (sb.length() > 1) {
                sb.append(',');
            }
            sb.append(v);
        }
        sb.append('}');
        return sb.toString();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            try {
                final String USERDIR = System.getProperty("user.dir");
                String cname = MethodHandles.lookup().lookupClass().getCanonicalName().replace(".MyScanner", "");
                cname = cname.lastIndexOf('.') > 0 ? cname.substring(cname.lastIndexOf('.') + 1) : cname;
                final File fin = new File(USERDIR + "/io/c" + cname.substring(1,4) + "/" + cname + ".in");
                br = new BufferedReader(new InputStreamReader(fin.exists()
                        ? new FileInputStream(fin) : System.in));
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int[] nextIntArr(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public int[][] nextIntArr2D(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }
    }
}
