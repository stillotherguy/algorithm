package algorithm.array;

/**
 * @author Ethan Zhang
 * @email ethan.zj@antfin.com
 */
public class StockComputeII {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int sum = 0;
        int prev = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                prev = prices[i];
                continue;
            }

            if (prices[i] - prev >= 0) {
                sum += prices[i] - prev;
            }

            prev = prices[i];
        }

        return sum;
    }

    // 非贪心算法
    public int maxProfit1(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int sum = 0;
        int initial = 0;
        int prev = 0;
        int step = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                prev = prices[i];
                continue;
            }

            if (prices[i] - prev <= 0 || i == prices.length - 1) {
                if (step > 0) {
                    if (i == prices.length - 1 && prices[i] - prev > 0) {
                        sum += prices[i] - initial;
                    } else {
                        sum += prev - initial;
                    }
                } else if (i == prices.length - 1 && prices[i] - prev > 0) {
                    sum += prices[i] - prev;
                }

                initial = 0;
                step = 0;
            } else {
                if (step == 0) {
                    initial = prev;
                }

                step++;
            }

            prev = prices[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,1,5,3,6,4};

        new StockComputeII().maxProfit(array);
        new StockComputeII().maxProfit1(array);

        array = new int[]{1,2,3,4,5};

        new StockComputeII().maxProfit(array);
        new StockComputeII().maxProfit1(array);

        array = new int[]{7,6,4,3,1};

        new StockComputeII().maxProfit(array);
        new StockComputeII().maxProfit1(array);
    }
}
