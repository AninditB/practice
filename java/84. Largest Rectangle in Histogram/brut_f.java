import java.lang.*;

public class brut_f {
    // Function largestRectangleArea(heights):
    public int largestRectangleArea(int[] heights) {
        // n ← length of heights
        // maxArea ← 0
        int n = heights.length;
        int maxArea = 0;

        // For i from 0 to n - 1:
        // minHeight ← ∞
        // For j from i to n - 1:
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                // minHeight ← minimum of minHeight and heights[j]
                // area ← minHeight × (j - i + 1)
                // maxArea ← maximum of maxArea and area
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        // Return maxArea
        return maxArea;
    }
}
