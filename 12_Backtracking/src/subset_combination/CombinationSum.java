package subset_combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int target, int i, List<Integer> curr, List<List<Integer>> res) {
        if (target < 0 || i == nums.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (nums[i] <= target) {
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i, curr, res);
            curr.removeLast();
        }
        backtrack(nums, target, i + 1, curr, res);
    }

    static void main() {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println(combinationSum(new int[] {2,3,5}, 8));
        System.out.println(combinationSum(new int[] {2}, 1));
    }
}
