public class MergeSortDemo {
    public static void main(String[] args) {
        int a[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // 两次入口以便他人调用(Java底层的sort就是这么做的)
    public static void mergeSort(int[] arr) {// 为了方便使用，直接转发至另一个排序实体中。
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        // 归并两个数组需要额外的数组空间，我们直接在此地new一个，防止递归时循环申请空间
        int[] temp = new int[arr.length];
        // 接下来进入递归体中。专门提取出来便于理解递归。
        mergeSort(arr, temp, left, right);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid = (left + right) / 2; // 求切分点
        if (right - left > 1) { // 子数组长度大于1时，进行拆分
            // 拆分两个数组
            mergeSort(arr, temp, left, mid); // 递归
            mergeSort(arr, temp, mid + 1, right); // 递归，注意mid已经属于前一个数组，所以记得+1
        }
        // 合并两个数组arr[left..mid]和 arr[mid..right]，两个数组都是有序数组，合并出来一个有序数组
        mergeArr(arr, temp, left, mid, right);
    }

    private static void mergeArr(int[] arr, int[] temp, int left, int mid, int right) {
        // 初始化左半区arr1的上界与下界
        int arr1Begin = left;
        int arr1End = mid;
        // 初始化右半区arr2的上界与下界
        int arr2Begin = mid + 1;
        int arr2End = right;
        // 初始化上面的目的：1.可读性强 2.在下面的逻辑中我们需要改变两个Begin的值，保存lo，mid，hi 的值。
        // 初始化中间数组的起始位置。
        int k = left;
        // 所有使用到的变量进行初始化完毕，开始合并arr1和arr2
        // 向temp中填入两个左右半区较小的元素
        while (arr1Begin <= arr1End && arr2Begin <= arr2End) {
            if (arr[arr1Begin] < arr[arr2Begin]) {// 左半区更小
                temp[k++] = arr[arr1Begin++];
            } else {
                temp[k++] = arr[arr2Begin++]; // 右半区更小
            }
        }
        // 合并左半区剩余的元素
        while (arr1Begin <= mid) {
            temp[k++] = arr[arr1Begin++];
        }
        // 合并右半区剩余的元素
        while (arr2Begin <= right) {
            temp[k++] = arr[arr2Begin++];
        }
        // 将结果数组中的值取出放到排序数组a[]中，完成a中数组排序。
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}
