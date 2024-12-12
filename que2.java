class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0; // Total count of arithmetic slices
        int curr = 0; // Current count of arithmetic slices ending at the current index
        int right = 0; // Store the previous count

        for (int i = nums.length - 3; i >= 0; i--) { // Start from the third last element
            // Check if three consecutive numbers form an arithmetic slice
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                curr = 1 + right; // Extend the previous arithmetic slice
            } else {
                curr = 0; // Reset if not an arithmetic slice
            }
            right = curr; // Update right for the next iteration
            count += curr; // Add to the total count
        }

        // System.out.println(Arrays.toString(dp)); // Debug print for DP array
        return count; // Return the total count of arithmetic slices
    }
}
