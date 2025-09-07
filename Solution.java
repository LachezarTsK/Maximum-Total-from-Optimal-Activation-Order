
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public long maxTotal(int[] value, int[] limit) {
        long maxTotalByActivatingOrders = Arrays.stream(value).asLongStream().sum();
        Map<Integer, PriorityQueue<Integer>> limitToValues = new HashMap<>();

        for (int i = 0; i < limit.length; ++i) {
            limitToValues.putIfAbsent(limit[i], new PriorityQueue<>());
            limitToValues.get(limit[i]).add(value[i]);

            if (limitToValues.get(limit[i]).size() > limit[i]) {
                maxTotalByActivatingOrders -= limitToValues.get(limit[i]).poll();
            }
        }

        return maxTotalByActivatingOrders;
    }
}
