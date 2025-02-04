package 排序;
public class MergeSort {
    /**
     * 归并排序算法。
     * 它将数组分为两半，分别对它们进行排序，然后将结果合并成一个有序数组。
     * 这个过程是递归的。
     *
     * @param arr    待排序的数组
     * @param left   子数组的起始索引
     * @param right  子数组的结束索引
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找到中间索引
            int mid = (left + right) / 2;
            // 递归排序左半部分
            mergeSort(arr, left, mid);
            // 递归排序右半部分
            mergeSort(arr, mid + 1, right);
            // 合并两个有序的部分
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个有序数组片段。
     *
     * @param arr    待合并的数组
     * @param left   左片段的起始索引
     * @param mid    中间索引，左片段的结束索引
     * @param right  右片段的结束索引
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // 左片段的大小
        int n2 = right - mid;    // 右片段的大小

        // 创建临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 拷贝数据到临时数组
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        // 合并临时数组到原数组
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 拷贝剩余的元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
