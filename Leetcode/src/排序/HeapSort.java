package 排序;

public class HeapSort {
    /**
     * 堆排序算法。
     * 它首先将数组转换为一个最大堆，然后逐个将堆顶元素（最大值）与堆的最后一个元素交换，
     * 并将堆的大小减一，重新调整堆，重复此过程直到堆的大小为1。
     *
     * @param arr 待排序的数组
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 逐个交换堆顶元素与最后一个元素，并重新调整堆
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    /**
     * 调整堆，使其成为最大堆。
     *
     * @param arr    待调整的数组
     * @param n      堆的大小
     * @param i      当前需要调整的节点索引
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 如果左子节点存在且大于当前最大值，更新最大值
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // 如果右子节点存在且大于当前最大值，更新最大值
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 如果最大值不是当前节点，交换最大值与当前节点，并继续调整以最大值为根的子堆
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
