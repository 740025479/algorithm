package org.wy.sort;


import java.util.Arrays;

public class Sort {

    /**
     * 冒泡排序
     * 时间复杂度：n2 (最好情况为n，需要加一个布尔值来判断第二层循环是否进行了交换)
     * 空间复杂度：占用常数内存
     * 稳定性：稳定
     * 原理：比较相邻值，每一轮比较出一个最大值，比较n轮
     */
    public int[] maoPao(int[] arr) {
        boolean didSwap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
//					swap(arr[j], arr[j + 1]);// java只有值传递，这样写是错的
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                return arr;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 时间复杂度：n2
     * 空间复杂度：占用常数内存
     * 稳定性：不稳定 eg:5,8,5,2
     * 原理：分为有序区和无序区,从无序区中找出最小值对应的索引，然后再交换索引对应的值
     */
    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr,i, minIndex);
        }
        return arr;
    }

    /**
     * 插入排序
     * 时间复杂度：n2 (最好情况n)
     * 空间复杂度：占用常数内存
     * 稳定性：稳定
     * 原理：分为有序区和无序区,向有序区插入无序区的值，有序区按照从后向前扫描
     */
    public int[] insertSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && arr[preIndex] > cur) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = cur;

        }
        return arr;
    }

    /**
     * 第二种插入排序，反方向来，有序区在后面，无序区在前面，有序区按照从前往后扫描
     *
     * @param arr
     * @return
     */
    public int[] insertSort1(int[] arr) {

        for (int i = arr.length - 1; i >= 1; i--) {
            int cur = arr[i - 1];
            int nextIndex = i;
            while (nextIndex < arr.length && arr[nextIndex] < cur) {
                arr[nextIndex - 1] = arr[nextIndex];
                nextIndex++;
            }
            arr[nextIndex - 1] = cur;

        }
        return arr;
    }

    /**
     * 希尔排序  （缩小增量排序，改进的插入排序）
     * 时间复杂度：与增量序列有关，nlogn
     * 空间复杂度：占用常数内存
     * 稳定性：不稳定
     * 原理：增量序列按照规律递减为1
     */
    public int[] shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int cur = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && cur < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }
            gap /= 2;
        }
        return arr;
    }

    /**
     * 归并排序
     * 时间复杂度：nlogn
     * 空间复杂度：占用n内存
     * 稳定性：稳定  对于对象来说，要稳定 所以Collections.sort()底层是归并，时间复杂度最低的稳定排序算法
     *                                      Arrays.sort()底层是快排改进版
     * 原理：分成元素数只有1的数组，然后再merge两个有序数组，最终合并成一个完整的
     */
    public void MergeSort(int[] arr){

        if (arr.length<1){return;}
        mergeSort(arr,0,arr.length-1);

    }

    private void mergeSort(int[] arr,int start,int end){
        if (start>=end){return;}
        int mid = start + (end-start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int p = start;
        int q = mid+1;
        int res = 0;
        int[] temp = new int[end-start+1];
        while (p<=mid&&q<=end){
            if (arr[p]<=arr[q]){
                temp[res]=arr[p];
                p++;
            }else {
                temp[res]=arr[q];
                q++;
            }
            res++;
        }
        while (p<=mid){
            temp[res]=arr[p];
            p++;
            res++;
        }
        while (q<=end){
            temp[res]=arr[q];
            q++;
            res++;
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i+start]=temp[i];
        }
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        /** 空间复杂度高了 */
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        return merge(mergeSort(left), mergeSort(right));

    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                res[index] = left[i++];
            } else if (left[i] <= right[j]) {
                res[index] = left[i++];
            } else {
                res[index] = right[j++];
            }
        }
        return res;
    }

    /**
     * 快速排序
     * 时间复杂度：nlogn
     * 空间复杂度：占用n内存
     * 稳定性：不稳定
     * 原理：每次根据中间值将数组分为两部分，在分别对这两部分排序。如何用基准值把数组分成两部分，用到两个指针
     */
    public int[] quickSort(int[] arr, int left, int right) {
        if (left<right) {
            int mid = partition(arr, left,right);
            quickSort(arr, 0, mid-1);
            quickSort(arr, mid+1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {

        int low = left;
        int high = right;
        int base = arr[left];
        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= base) {
                low++;
            }
            swap(arr, low, high);
        }

        return low;
    }

    /**
     * 堆排序
     * 时间复杂度：nlogn
     * 空间复杂度：占用n内存
     * 稳定性：稳定
     * 原理：最大堆的定义：每个父节点都比所有子节点大。、
     * 思路：先把数组建最大堆，然后将堆顶与堆的右下叶子节点交换，即数组的首尾交换，交换之后再调整至最大堆
     * 踩过的坑：因为是每个父节点，所以在建立堆的时候，需要循环或者递归来保证。
     * 			或者说，在从上至下调整完全二叉树为堆的时候，需要循环保证
     * 				即：child = parent*2+1;
     * 					parent = child;
     */
    public void heapSort(int[] arr) {
        buildMaxHeap(arr, 0, arr.length-1);
        int index = arr.length-1;
        while (index>=0) {
            swap(arr, 0, index);
            index--;
            downToMaxHeap(arr, 0, index);
        }
    }

    private void buildMaxHeap(int[] arr,int start,int end) {
        int parent = (end-1)/2;
        while (parent>=0) {
            downToMaxHeap(arr, parent, end);
            parent--;
        }
    }

    private void downToMaxHeap(int[] arr,int start,int end) {
//		swap(arr, start, end);
        int parent = start;
        int child;
        while ((child=parent*2+1)<=end) {
            if (child<end&&arr[child]<arr[child+1]) {
                child++;
            }
            if (arr[child]>arr[parent]) {
                swap(arr, child, parent);
            }else {
                break;
            }
            parent = child;
        }
    }


    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }



    public static void main(String[] args) {
        int[] arr = new int[] { 145, 23, 6, 55, 64, 86, 4, 66, 11, 36, 71, 17 };
        int[] arr1 = new int[] { 145, 23, 6, 55, 64, 86, 4, 66, 11, 36, 71, 17 };
        int[] arr2 = new int[] { 145, 23, 6, 55, 64, 86, 4, 66, 11, 36, 71, 17 };
        int[] arr3;
        Sort sort = new Sort();
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        arr3 = sort.mergeSort(arr1);
        System.out.println(Arrays.toString(arr3));
        sort.maoPao(arr2);
        System.out.println(Arrays.toString(arr2));
        sort.heapSort(arr2);
        System.out.println(Arrays.toString(arr2));


        int[] arr4 = new int[] { 145, 23, 6, 55, 64, 86, 4, 66, 11, 36, 71, 17 };
        sort.MergeSort(arr4);
        System.out.println(Arrays.toString(arr4));
    }

}

