package Array;

public class canCompleteCircuit {
    // Leetcode 134

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i ++) {
            int g = gas[i];
            int stations = 0;
            // 从i站出发
            for (int j = i; stations < gas.length; j ++) {
                if (g < cost[j % gas.length])
                    break;
                g = g - cost[j % gas.length] + gas[(j + 1) % gas.length];
                stations += 1;
                if (stations == gas.length)
                    return i;
            }
        }
        return -1;
    }

    public static int solution2(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution2(gas,cost));
    }
}
