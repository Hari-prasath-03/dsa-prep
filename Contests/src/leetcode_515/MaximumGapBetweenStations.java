package leetcode_515;

public class MaximumGapBetweenStations {
    public static int maximumGap(String skill, String station) {
        int n = skill.length(), m = station.length();

        char[] skillArr = skill.toCharArray();
        char[] stationArr = station.toCharArray();

        int pos = 0;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (stationArr[pos] != skillArr[i]) pos++;
            left[i] = pos++;
        }

        pos = m - 1;
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (stationArr[pos] != skillArr[i]) pos--;
            right[i] = pos--;
        }

        int maxGap = 0;
        for (int i = 0; i < n - 1; i++) {
            int gap = right[i + 1] - left[i];
            maxGap = Math.max(maxGap, gap);
        }
        return maxGap;
    }

    static void main() {
        System.out.println(maximumGap("aa", "aaaa")); // 3
        System.out.println(maximumGap("xyz", "xyzz")); // 2
        System.out.println(maximumGap("cbc", "cbcdbc")); // 4
    }
}
