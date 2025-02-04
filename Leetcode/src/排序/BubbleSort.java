package 排序;

public class BubbleSort {
    /**
     * 冒泡排序算法。
     * 它重复地遍历待排序的列表，比较每对相邻的项目，并交换不满足排序顺序的项。
     * 每次遍历会将未排序部分的最大元素“冒泡”到正确的位置。
     *
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制遍历的轮数
        for (int i = 0; i < n - 1; i++) {
            // 内层循环负责比较相邻元素并交换
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
