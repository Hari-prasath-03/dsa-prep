package arrays.hashing;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

class IntersectionOfArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) set.add(num);
        
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) if (set.contains(num)) result.add(num);
             
        int i = 0;
        int[] output = new int[result.size()];
        for (int num : result) output[i++] = num;
        return output;
    }

    public static int[] intersectionWithTable(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];
        for (int num : nums1) seen[num] = true;
        
        int i = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        for (int num : nums2) {
            if (seen[num]) {
                res[i++] = num;
                seen[num] = false;
            }
        }

        return Arrays.copyOf(res, i);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionWithTable(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }
}