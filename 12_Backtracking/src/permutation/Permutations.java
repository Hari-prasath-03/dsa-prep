package permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] pick, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                curr.add(nums[i]);
                pick[i] = true;
                backtrack(nums, pick, curr, res);
                curr.removeLast();
                pick[i] = false;
            }
        }
    }

    static void main() {
        System.out.println(permute(new int[] {1,2,3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permute(new int[] {0,1})); // [[0,1],[1,0]]
        System.out.println(permute(new int[] {1})); // [[1]]
    }
}
