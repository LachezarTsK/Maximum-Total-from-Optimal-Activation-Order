
using System;
using System.Linq;
using System.Collections.Generic;

public class Solution
{
    public long MaxTotal(int[] value, int[] limit)
    {
        long maxTotalByActivatingOrders = value.Sum(x => (long)x);
        Dictionary<int, PriorityQueue<int, int>> limitToValues = [];

        for (int i = 0; i < limit.Length; ++i)
        {
            limitToValues.TryAdd(limit[i], new PriorityQueue<int, int>());
            limitToValues[limit[i]].Enqueue(value[i], value[i]);

            if (limitToValues[limit[i]].Count > limit[i])
            {
                maxTotalByActivatingOrders -= limitToValues[limit[i]].Dequeue();
            }
        }

        return maxTotalByActivatingOrders;
    }
}
