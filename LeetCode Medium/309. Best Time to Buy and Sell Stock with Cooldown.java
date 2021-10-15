// 309. Best Time to Buy and Sell Stock with Cooldown
//By Ratna Priya

public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, true, new Integer[2][prices.length]);
    }

    private int maxProfit(int[] prices, int idx, boolean expectedBuy, Integer[][] cache) {
        if (idx >= prices.length) {
            return 0;
        } else if (idx == prices.length - 1) {
            return expectedBuy ? 0 : prices[idx];
        }
        int direction = expectedBuy ? 0 : 1;
        if (cache[direction][idx] != null) {
            return cache[direction][idx];
        } else {
            int profit;
            if (expectedBuy) {
                // Buy
                profit = Math.max(
                      -prices[idx] + maxProfit(prices, idx + 1, false, cache),
                      maxProfit(prices, idx + 1, true, cache)
                );
            } else {
                // Sell
                profit = Math.max(
                      prices[idx] + maxProfit(prices, idx + 2, true, cache),
                      maxProfit(prices, idx + 1, false, cache)
                );
            }
            cache[direction][idx] = profit;
            return profit;
        }
    }
