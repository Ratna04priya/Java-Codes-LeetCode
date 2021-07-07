// 1338.Reduce Array Size to The Half
//By Ratna Priya

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        int[] bucket = new int[n + 1];
        for (int freq : cnt.values()) ++bucket[freq];

        int ans = 0, removed = 0, half = n / 2, freq = n;
        while (removed < half) {
            ans += 1;
            while (bucket[freq] == 0) --freq;
            removed += freq;
            --bucket[freq];
        }
        return ans;
    }
}
