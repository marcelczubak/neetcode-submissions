class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left)/2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);

    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;  // left half
        int j = mid+1; // right half
        int k = 0;     // temp array


        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        for (int m = 0; m < temp.length; m++) {
            nums[left + m] = temp[m];
        }
    }


}