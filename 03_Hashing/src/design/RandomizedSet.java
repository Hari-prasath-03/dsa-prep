package design;

import java.util.*;

public class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int i = map.get(val);
        int lastNum = list.getLast();

        list.set(i, lastNum);
        list.removeLast();
        map.put(lastNum, i);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    static void main() {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(10));
        System.out.println(set.insert(5));
        System.out.println(set.insert(9));
        System.out.println(set.insert(10));
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.remove(5));
        System.out.println(set.remove(5));
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
    }
}
