package 排序;
public class QuickSortHoare {

    // 主函数，调用快速排序方法
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 快速排序函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区索引
            int pi = partition(arr, low, high);

            // 对左子数组进行排序
            quickSort(arr, low, pi);
            // 对右子数组进行排序
            quickSort(arr, pi + 1, high);
        }
    }

    // Hoare 分区方案
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // 选择第一个元素作为基准
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // 从左向右移动，找到大于等于 pivot 的元素
            do {
                i++;
            } while (arr[i] < pivot);

            // 从右向左移动，找到小于等于 pivot 的元素
            do {
                j--;
            } while (arr[j] > pivot);

            // 如果指针相遇或交错，返回分区点
            if (i >= j)
                return j;

            // 交换 arr[i] 和 arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
