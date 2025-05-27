import java.util.*;

public class sol_hm_sort {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Step 2: Convert freqMap to list of (num, frequency) pairs
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Step 3: Sort freqList by descending frequency
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Get top k keys
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i).getKey();
        }

        return result;
    }
}
