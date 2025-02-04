package 排序;

public class QuickSort {
    /**
     * 快速排序算法。
     * 它通过选择一个“基准”元素，将数组分为两个子数组，比基准小的元素在基准的左边，
     * 比基准大的元素在基准的右边，然后递归地在两个子数组上重复这个过程。
     *
     * @param arr  待排序的数组
     * @param low  子数组的起始索引
     * @param high 子数组的结束索引
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 分区操作，将数组分为两部分
            int pi = partition(arr, low, high);
            // 递归排序左子数组
            quickSort(arr, low, pi - 1);
            // 递归排序右子数组
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * 对数组进行分区，选择一个基准元素，将比基准小的元素放在左边，比基准大的元素放在右边。
     *
     * @param arr  待分区的数组
     * @param low  分区的起始索引
     * @param high 分区的结束索引
     * @return 基准元素的最终位置
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准
        int i = low - 1; // i是小于基准的元素的最后一个位置的索引
        for (int j = low; j < high; j++) {
            // 当前元素小于或等于基准
            if (arr[j] < pivot) {
                i++;
                // 交换元素
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 将基准元素放到正确的位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // 返回基准元素的最终位置
    }
}
