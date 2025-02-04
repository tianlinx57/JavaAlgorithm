package 排序;

public class InsertionSort {
    /**
     * 插入排序算法。
     * 它通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * @param arr 待排序的数组
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // 当前待插入的元素
            int j = i - 1;
            // 将当前元素与已排序的元素从后向前比较
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // 将较大的元素向后移动
                j = j - 1;
            }
            // 将当前元素插入到正确的位置
            arr[j + 1] = key;
        }
    }
}
