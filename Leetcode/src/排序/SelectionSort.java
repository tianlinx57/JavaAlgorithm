package 排序;

public class SelectionSort {
    /**
     * 选择排序算法。
     * 它每次从未排序的部分选出最小（或最大）的元素，将其放到已排序序列的末尾。
     *
     * @param arr 待排序的数组
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制遍历的轮数
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // 内层循环负责找出未排序部分的最小元素的索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小元素交换到已排序部分的末尾
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
