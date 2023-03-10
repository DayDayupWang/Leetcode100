class quickSortDemo {
    public static void main(String[] args) {
        int[] num = new int[] { 10, 5, 6, 9, 3, 2, 1, 5, 6, 4, 3, 6 };
        quickSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }

    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        // 如果区域内的数字少于 2 个，退出递归
        if (start >= end)
            return;
        // 将数组分区，并获得中间值的下标
        int middle = partition(arr, start, end);
        // 对左边区域快速排序
        quickSort(arr, start, middle - 1);
        // 对右边区域快速排序
        quickSort(arr, middle + 1, end);
    }

    // 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    public static int partition(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // left、right 相遇时退出循环
        while (left < right) {
            // 找到左侧过去第一个大于基数的位置
            while (left < right && arr[left] <= pivot)
                left++;
            // 找到右侧而来第一次小于基数的位置
            while (left < right && pivot <= arr[right])
                right--;
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            exchange(arr, left, right);
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        // 如果右元素大于基数，让右下标-1
        if (left == right && arr[right] > pivot)
            right--;
        // 将基数和中间数交换
        if (right != start)
            exchange(arr, start, right);
        // 返回中间数的下标
        return right;
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
