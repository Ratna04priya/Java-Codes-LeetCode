// 528. Random Pick with Weight- https://leetcode.com/problems/random-pick-with-weight/
//By Ratna Priya
class Solution {
    private Random random;
    private int[] sum;
    private int max;
    // Time complexity: O(N)
    public Solution(int[] w) {
        random = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i-1] + w[i];
        }
        max = sum[w.length - 1];
    }
    // Time complexity: O(logN)
    public int pickIndex() {
        int randInt = random.nextInt(max) + 1;
        int idx = Arrays.binarySearch(sum, randInt);
        if (idx < 0) idx = -idx - 1;
        return idx;
    }
}
