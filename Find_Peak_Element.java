class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i; // Found a peak
            }
        }
        return n - 1; // If no peak found, last element is a peak
    }
}
