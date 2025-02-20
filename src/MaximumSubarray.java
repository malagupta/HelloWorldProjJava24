void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxEndingHere = nums[0];
    int maxSoFar = nums[0];
    for (int i = 1; i < nums.length; i++) {
        maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    int maxSum = maxSoFar;
    println("Maximum subarray sum: " + maxSum);
}