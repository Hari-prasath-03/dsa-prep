package leetcode_515;

public class NearestAvailableDrone {
    private static int manhattanDistance(int[] d, int[] t) {
        int distance = Math.abs(d[0] - t[0]) + Math.abs(d[1] - t[1]);
        return distance <= d[2] ? distance : -1;
    }

    public static int nearestDrone(int[][] drones, int[] target) {
        int idx = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < drones.length; i++) {
            int distance = manhattanDistance(drones[i], target);
            if (distance != -1 && distance < minDistance) {
                minDistance = distance;
                idx = i;
            }
        }
        return idx;
    }

    static void main() {
        System.out.println(nearestDrone(new int[][] {{0,0,8}, {2,2,9}}, new int[] {3,4})); // 1
        System.out.println(nearestDrone(new int[][] {{2,1,5}, {4,4,5}, {6,6,8}}, new int[] {5,5})); // 1
        System.out.println(nearestDrone(new int[][] {{4,4,5}}, new int[] {8,6})); // -1
    }
}
