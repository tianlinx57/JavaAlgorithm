package 排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(100000000); // 调整数组大小以适应不同的测试需求
        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy3 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy4 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy5 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy6 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy7 = Arrays.copyOf(arr, arr.length);

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort 时间: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        QuickSortHoare.quickSort(arrCopy7, 0, arr.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("QuickSortHoare 时间: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(arrCopy1, 0, arrCopy1.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("MergeSort 时间: " + (endTime - startTime) + " ms");

        // startTime = System.currentTimeMillis();
        // InsertionSort.insertionSort(arrCopy2);
        // endTime = System.currentTimeMillis();
        // System.out.println("InsertionSort 时间: " + (endTime - startTime) + " ms");
        //
        // startTime = System.currentTimeMillis();
        // BubbleSort.bubbleSort(arrCopy3);
        // endTime = System.currentTimeMillis();
        // System.out.println("BubbleSort 时间: " + (endTime - startTime) + " ms");
        //
        // startTime = System.currentTimeMillis();
        // SelectionSort.selectionSort(arrCopy4);
        // endTime = System.currentTimeMillis();
        // System.out.println("SelectionSort 时间: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        HeapSort.heapSort(arrCopy5);
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort 时间: " + (endTime - startTime) + " ms");

        // 桶排序通常用于特定类型的数据，例如浮点数范围在[0, 1)之间的数据。
        // 如果需要测试桶排序，请确保数据适合桶排序的使用场景。
        // 这里我们用一个简单的例子来演示桶排序。
        int[] arrForBucketSort = generateRandomArrayForBucketSort(10000000, 100);
        startTime = System.currentTimeMillis();
        BucketSort.bucketSort(arrForBucketSort, 10);
        endTime = System.currentTimeMillis();
        System.out.println("BucketSort 时间: " + (endTime - startTime) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }

    // 生成一个适用于桶排序的随机数组，值在0到max之间。
    private static int[] generateRandomArrayForBucketSort(int size, int max) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }
}
