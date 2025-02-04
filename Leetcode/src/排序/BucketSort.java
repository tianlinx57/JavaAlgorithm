package 排序;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    /**
     * 桶排序算法。
     * 它将元素分配到多个桶中，每个桶是一个有序的列表，然后对每个桶单独进行排序，
     * 最后依次合并每个桶中的元素，得到排序后的数组。
     *
     * @param arr        待排序的数组
     * @param bucketSize 每个桶的大小
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];
        // 找到数组中的最小值和最大值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 计算桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素分配到桶中
        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] - min) / bucketSize).add(arr[i]);
        }

        // 对每个桶中的元素进行排序，并合并到原数组中
        int index = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr[index++] = buckets.get(i).get(j);
            }
        }
    }
}
