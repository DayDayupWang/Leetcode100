public class solution912 {
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums);
    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(nums, start, end);

        quickSort(nums, start, mid);
        quickSort(nums, mid + 1, end);

    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < right && nums[left] < pivot) {
                left++;
            }
            while (left < right && nums[right] > pivot) {
                right--;
            }

            swap(nums, left, right);

        }
        if (left == right && nums[left] > pivot) {
            right--;
        }
        if (right!=start) {
            swap(nums, start, right);
        }
        return right;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
