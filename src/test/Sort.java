package test;

public class Sort {

    private void swap(int[] a, int sourceIndex, int targetIndex) {
        int temp = a[sourceIndex];
        a[sourceIndex] = a[targetIndex];
        a[targetIndex] = temp;
    }

    /**
     * 第一类，交换排序
     */

    public void maoPao(int[] a) {

        boolean didswap = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    didswap = true;
                }
            }
            if (!didswap) {
                return;
            }
        }

    }

    /**
     * 以最左为基准
     * 不以最左为基准时，可以先选一个，然后跟最左交换，又变成一样的了 哈哈，
     */
    public void quickSort(int[] a, int start, int end) {
        if (start <= end) {
            return;
        }
        int base = a[start];
        int p = start;
        int q = end;
        while (p < q) {
            while (p < q && a[q] >= base) {
                q--;
            }
            swap(a, p, q);
            while (p < q && a[p] <= base) {
                p++;
            }
            swap(a, p, q);
        }
        a[p] = base;
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    /**
     * 最右为基准
     */
    public void quickSort2(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;
        int base = a[high];
        while (low < high) {
            while (low < high && a[low] <= base) {
                low++;
            }
            swap(a, low, high);
            while (low < high && a[high] >= base) {
                high--;
            }
            swap(a, low, high);
        }
        quickSort(a, start, low - 1);
        quickSort(a, low + 1, end);
    }


    /**
     * 第二类  选择排序
     */
    public void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }
    }

    /**
     * 堆排序
     * 最大堆的定义：每个父节点都比所有子节点大。。因此需要先保证子节点是堆
     *
     * @param a
     */
    public void topHeapSort(int[] a) {

        int index = a.length - 1;
        buildTopHeap(a, 0, index);
        while (index > 0) {
            swap(a, 0, index);
            downToTopHeap(a, 0, index - 1);
            index--;
        }
    }

    private void buildTopHeap(int[] a, int start, int end) {
        int hasChildIndex = (end - 1) / 2;

        /**
         * 构造堆时，从下往上构造。  因为从上往下构造，只能判断当前节点比子节点都大，但是子节点的子节点不一定就比他小
         *                          但如果是从下往上构造，就可以保证当当前节点比子节点大时，就一定比子节点的子节点大，因为此时的子节点已经是一个小型堆
         */
        for (int i = hasChildIndex; i >= 0; i--) {
            downToTopHeap(a, i, end);
        }
    }

    private void downToTopHeap(int[] a, int start, int end) {
        int hasChildIndex = (end - 1) / 2;
        int parent = start;
        while (parent <= hasChildIndex) {
            int child = parent * 2 + 1;
            if (child < end && a[child] < a[child + 1]) {
                child++;
            }
            if (a[child] > a[parent]) {
                swap(a, child, parent);
            } else {
                break;
            }
            parent = child;
        }
    }


    /**
     * 第三类： 插入排序
     */


    /**
     * 从无序数列中从左往右一次选一个，插入到有序序列中
     */
    public void insertSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[index]) {
                    swap(a, j, index);
                    index = j;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < a.length - 1; i++) {
            int cur = a[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && a[preIndex] > cur) {
                a[preIndex + 1] = a[preIndex];
                preIndex--;
            }
            a[preIndex + 1] = cur;
        }

    }


    /**
     * 希尔排序，缩小增量插入，对于每个增量，进行插入排序
     */
    public void shellSort(int[] a) {

        int gap = a.length / 2;
        while (gap > 0) {
            for (int i = gap; i < a.length; i++) {
                int preIndex = i - gap;
                int cur = a[i];
                while (preIndex >= 0 && a[preIndex] > cur) {
                    a[preIndex + gap] = a[preIndex];
                    preIndex -= gap;
                }
                a[preIndex + gap] = cur;
            }
            gap /= 2;
        }

    }


    /**
     * 归并排序
     */
    public void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index = mid + 1;
        int from = start;
        for (int i = 0; i < temp.length; i++) {
            if (start >= mid) {
                temp[i] = a[index];
                index++;
            } else if (index >= end) {
                temp[i] = a[start];
                start++;
            } else if (a[start] > a[index]) {
                temp[i] = a[index];
                index++;
            } else {
                temp[i] = a[start];
                start++;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            a[from + i] = a[i];
        }
    }


    /**
     * 基数排序
     * 找出待排序序列中最大和最小值，然后新建数组用于存储在两值之间，值为序号的数的个数
     */
    public void baseSort(int[] a) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i]>maxVal){
                maxVal = a[i];
            }
            if (a[i]<minVal){
                minVal = a[i];
            }
        }
        int[] temp = new int[maxVal - minVal + 1];
        for (int i = 0; i < a.length; i++) {
            temp[a[i] - minVal]++;
        }
        int index = 0;

        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                a[index] = i + minVal;
                index++;
                temp[i]--;
            }
        }


    }






    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return isValidBST(root,max,min);
    }
    private boolean isValidBST(TreeNode root,long maxVal,long minVal){
        if (root==null){
            return true;
        }
        if (root.val>=maxVal || root.val<=minVal){
            return false;
        }
        return isValidBST(root.left,root.val,minVal)&&isValidBST(root.right,maxVal,root.val);
    }





}
