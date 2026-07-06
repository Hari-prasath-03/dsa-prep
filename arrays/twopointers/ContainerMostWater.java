package twopointers;

public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0, r = height.length - 1;
        while (l < r) {
            int length = Math.min(height[l], height[r]);
            int breadth = r - l;
            int area = length * breadth;
            maxArea = Math.max(maxArea, area);

            if (height[l] < height[r]) l++;
            else r--;
        }

        return maxArea;
    }

    static void main() {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[] {1,1})); // 1
    }
}
