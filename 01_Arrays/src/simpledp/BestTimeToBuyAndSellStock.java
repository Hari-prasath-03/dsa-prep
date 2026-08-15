package simpledp;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;

        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[] {7,6,4,3,1})); // 0
    }
}
