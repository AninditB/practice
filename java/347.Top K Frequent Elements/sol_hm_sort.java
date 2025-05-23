import java.util.HashMap;

public class sol_hm_sort {
    public int[] topKFrequent(int[] nums, int k) {
        for (int num : nums) {
            freqMap.put(nu, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Ineger, Integer>> freqList = new ArrayList<>(freqMap.entrySet());
        frequList.sort((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i).getKey();
        }
        return result;
    }
}
