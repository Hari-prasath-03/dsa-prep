package subset_combination;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, j + 1, curr, res);
            curr.removeLast();
        }
    }

    static final List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets1(int[] nums) {
        res.clear();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private static void backtrack(int[] nums, int i, List<Integer> curr) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, i + 1, curr);
        curr.removeLast();
        backtrack(nums, i + 1, curr);
    }

    static void main() {
        System.out.println(subsets1(new int[] {1,2,3}));
        System.out.println(subsets1(new int[] {0}));
    }
}
