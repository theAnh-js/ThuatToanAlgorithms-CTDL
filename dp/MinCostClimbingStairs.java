package dp;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int money[] = new int[cost.length + 1];

        money[0] = 0;
        money[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            money[i] = Math.min(cost[i - 1] + money[i - 1], cost[i - 2] + money[i - 2]);
        }

        return money[money.length - 1];
    }
}
