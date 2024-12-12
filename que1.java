/*
 * Time Complexity (TC): O(n^2) - We iterate through each element in the triangle in a nested loop.
 * Space Complexity (SC): O(1) - We use the input triangle itself to store intermediate results.
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Bottom-up DP approach: Start from the second-last row and move upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int current = triangle.get(i).get(j); // Current element in the triangle
                
                // Minimum path sum by moving down
                int down = triangle.get(i + 1).get(j);

                // Minimum path sum by moving diagonally down
                int diagonalDown = triangle.get(i + 1).get(j + 1);

                // Update the current element in the triangle with the minimum path sum
                triangle.get(i).set(j, current + Math.min(down, diagonalDown));
            }
        }

        // The minimum path sum from the top to the bottom is now stored at triangle[0][0]
        return triangle.get(0).get(0);
    }
}
