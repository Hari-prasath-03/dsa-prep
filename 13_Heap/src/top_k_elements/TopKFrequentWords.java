package top_k_elements;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> feq = new HashMap<>();
        for (String word: words) feq.put(word, feq.getOrDefault(word, 0) + 1);

        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) return b.getKey().compareTo(a.getKey());
            return a.getValue() - b.getValue();
        });

        for (Map.Entry<String, Integer> entry: feq.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) heap.poll();
        }

        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.addFirst(heap.poll().getKey());
        }
        return result;
    }

    static void main() {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
}
