import java.util.*;

public class sol_hm_sort {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        // Create empty HashMap freqMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        // For each num in nums:
        // If freqMap contains num:
        // Increment freqMap[num] by 1
        // Else:
        // Set freqMap[num] = 1
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert freqMap to list of (num, frequency) pairs
        // Create list freqList from entries of freqMap
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort freqList by descending frequency
        // Sort freqList based on value in descending order
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Get top k keys
        // Create empty list result of size k
        int[] result = new int[k];
        // For i from 0 to k - 1:
        // --- result[i] = freqList[i].key
        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i).getKey();
        }
        // Return result
        return result;
    }
}
