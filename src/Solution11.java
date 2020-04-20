public class Solution11 {
    public int maxArea(int[] height) {
        int area = 0, l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.max(area, Math.min(height[l],height[r]) * (r-l));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return area;
    }
}
