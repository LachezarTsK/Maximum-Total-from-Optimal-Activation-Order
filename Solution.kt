
import java.util.*

class Solution {

    fun maxTotal(value: IntArray, limit: IntArray): Long {
        var maxTotalByActivatingOrders: Long = Arrays.stream(value).asLongStream().sum()
        val limitToValues = mutableMapOf<Int, java.util.PriorityQueue<Int>>()

        for (i in limit.indices) {
            limitToValues.putIfAbsent(limit[i], java.util.PriorityQueue<Int>())
            limitToValues[limit[i]]!!.add(value[i])

            if (limitToValues[limit[i]]!!.size > limit[i]) {
                maxTotalByActivatingOrders -= limitToValues[limit[i]]!!.poll()
            }
        }

        return maxTotalByActivatingOrders;
    }
}
