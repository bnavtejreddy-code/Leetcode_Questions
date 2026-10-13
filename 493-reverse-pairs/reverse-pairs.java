class Solution {

    public int countPair(int[] arr,int low,int mid,int high){
        int cnt = 0;
        
        int right = mid+1;
        for(int i = low;i<=mid;i++){
            while(right<=high && arr[i]> (long)2*arr[right]){
                right++;
            }
            cnt += right-(mid+1);
            
        }
        return cnt;
    }
    // Merges two sorted ranges into the original array.
    public void merge(int[] arr, int left, int mid, int right) {
        List<Integer> leftPart = new ArrayList<>();
        List<Integer> rightPart = new ArrayList<>();
 
        // Copy left range to preserve values during merging.
        for (int index = left; index <= mid; index++) {
            leftPart.add(arr[index]);
        }
 
        // Copy right range for safe comparison during merging.
        for (int index = mid + 1; index <= right; index++) {
            rightPart.add(arr[index]);
        }
 
        int leftIndex = 0;
        int rightIndex = 0;
        int writeIndex = left;
 
        // Compare both ranges until one becomes empty.
        while (leftIndex < leftPart.size() && rightIndex < rightPart.size()) {
            // Take from left on equality to keep sorting stable.
            if (leftPart.get(leftIndex) <= rightPart.get(rightIndex)) {
                arr[writeIndex] = leftPart.get(leftIndex);
                leftIndex++;
            } else {
                arr[writeIndex] = rightPart.get(rightIndex);
                rightIndex++;
            }
            writeIndex++;
        }
 
        // Copy remaining left values as they are already sorted.
        while (leftIndex < leftPart.size()) {
            arr[writeIndex] = leftPart.get(leftIndex);
            leftIndex++;
            writeIndex++;
        }
 
        // Copy remaining right values as they are already sorted.
        while (rightIndex < rightPart.size()) {
            arr[writeIndex] = rightPart.get(rightIndex);
            rightIndex++;
            writeIndex++;
        }
    }
 
    // Divides the range and merges both sorted halves.
    public int mergeSortHelper(int[] arr, int left, int right) {
        // A range of zero or one value is already sorted.
        int cnt = 0;
        if (left >= right) {
            return cnt;
        }
 
        int mid = left + (right - left) / 2;
 
        // Sort left half before merging.
        cnt += mergeSortHelper(arr, left, mid);
 
        // Sort right half before merging.
        cnt += mergeSortHelper(arr, mid + 1, right);


        cnt += countPair(arr,left,mid,right);
        // Merge both sorted halves.
        merge(arr, left, mid, right);
        return cnt;
    }
 
    // Sorts the array using merge sort.
    public int mergeSort(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        // Arrays with fewer than two values are already sorted.
        if (n < 2) {
            return cnt;
        }
 
        cnt += mergeSortHelper(arr, 0, n - 1);
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums);
    }
}