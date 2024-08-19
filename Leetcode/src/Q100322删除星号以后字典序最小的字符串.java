import java.util.PriorityQueue;

//最小堆
public class Q100322删除星号以后字典序最小的字符串 {

    public class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K, V>> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int compareTo(Pair<K, V> other) {
            int keyComparison = this.key.compareTo(other.getKey());
            if (keyComparison != 0) {
                return keyComparison;
            } else {
                return -this.value.compareTo(other.getValue());
            }
        }

        @Override
        public String toString() {
            return "Pair{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public String clearStars(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        PriorityQueue<Pair<Character,Integer>> priorityQueue = new PriorityQueue<>();
        int[] deleted = new int[n];
        for(int i=0;i<n;i++){
            if(chars[i] != '*'){
                priorityQueue.offer(new Pair<>(chars[i],i));
                continue;
            }
            Pair<Character,Integer> pair = priorityQueue.poll();
            deleted[pair.getValue()] = 1;
            deleted[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(deleted[i] != 1){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q100322删除星号以后字典序最小的字符串 solution = new Q100322删除星号以后字典序最小的字符串();
        // PriorityQueue<Pair<Character,Integer>> priorityQueue = new PriorityQueue<>();
        // priorityQueue.offer(solution.new Pair<>('a',1));
        // priorityQueue.offer(solution.new Pair<>('a',2));
        // priorityQueue.offer(solution.new Pair<>('a',0));
        // priorityQueue.offer(solution.new Pair<>('b',0));
        // priorityQueue.offer(solution.new Pair<>('z',0));
        // System.out.println(priorityQueue);
        System.out.println(solution.clearStars("aaba*"));
    }
}