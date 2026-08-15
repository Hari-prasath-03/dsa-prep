package searchonsolution;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n2 < n1) return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        int left = (n + 1) / 2;
        int start = 0, end = n1;
        while (start <= end) {
            int mid1 = (start + end) >> 1;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) end = mid1 - 1;
            else start = mid1 + 1;
        }

        return 0.0;
    }

    static void main() {
        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(findMedianSortedArrays(new int[] {1, 3, 4, 7, 10, 12}, new int[] {2, 3, 6, 15}));
        System.out.println(findMedianSortedArrays(new int[] {2, 4}, new int[] {1, 3, 4}));
    }
}
