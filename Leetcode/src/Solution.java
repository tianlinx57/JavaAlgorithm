// 代码中已指定的类名、方法名、参数名，请勿修改，直接返回方法规定的值即可

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {



        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String s:words){
            hashMap.put(s,hashMap.getOrDefault(s,0)+1);
        }
        TreeSet<IntString> treeSet = new TreeSet<>();
        for(String s:hashMap.keySet()){
            treeSet.add(new IntString(hashMap.get(s),s));
        }
        for(int i=0;i<k;++i){
            ans.add(treeSet.getLast().s);
            treeSet.removeLast();
        }
        return ans;



    }
    class IntString implements Comparable<IntString>{
        int i;
        String s;

        IntString(int ii,String ss){
            i=ii;
            s=ss;
        }

        @Override
        public int compareTo(IntString o) {
            if(i!=o.i){
                return Integer.compare(i,o.i);
            }
            return o.s.compareTo(s);

        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new String[]{"i", "love", "meituan", "i", "love", "coding"},3));
    }
}