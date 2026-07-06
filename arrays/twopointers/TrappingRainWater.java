package twopointers;

public class TrappingRainWater {
    // time O(2N) -> O(N), space = O(2N) -> O(N)
    public static int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[j] = Math.max(right[j + 1], height[j]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }

    // time: O(N), space = O(1)
    public static int twoPointerTrap(int[] height) {
        int n = height.length;
        int maxLeft = 0, maxRight = 0;
        int water = 0;

        int l = 0, r = n - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= maxLeft) maxLeft = height[l];
                else water += maxLeft - height[l];
                l++;
            } else {
                if (height[r] >= maxRight) maxRight = height[r];
                else water += maxRight - height[r];
                r--;
            }
        }

        return water;
    }

    static void main() {
        System.out.println(twoPointerTrap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(twoPointerTrap(new int[] {4,2,0,3,2,5})); // 9
        System.out.println(twoPointerTrap(new int[] {0,2,0,3,1,0,1,3,2,1})); // 9
    }
}
