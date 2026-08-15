package convergingpointers;

import utils.Arrays2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int l = i + 1, r = n - 1;
                while (l < r) {
                    int sum = nums[l] + nums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (target > sum) l++;
                    else r--;
                }
            }
        }

        return list;
    }

    static void main() {
        Arrays2D.print2dArray(threeSum(new int[] {-1,0,1,2,-1,-4}));
        Arrays2D.print2dArray(threeSum(new int[] {0,1,1}));
        Arrays2D.print2dArray(threeSum(new int[] {0,0,0}));
    }
}
