package counting;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int curr = 0, cnt = 0;

        for (int num: nums) {
            if (cnt == 0) curr = num;
            if (curr == num) cnt++;
            else cnt--;
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
