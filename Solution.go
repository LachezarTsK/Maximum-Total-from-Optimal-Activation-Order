
package main
import "container/heap"

func maxTotal(value []int, limit []int) int64 {
    var maxTotalByActivatingOrders int64 = 0
    for i := range value {
        maxTotalByActivatingOrders += int64(value[i])
    }
    limitToValues := map[int]*PriorityQueue{}

    for i := range limit {
        if _, has := limitToValues[limit[i]]; !has {
            limitToValues[limit[i]] = &PriorityQueue{}
        }
        heap.Push(limitToValues[limit[i]], value[i])
        if limitToValues[limit[i]].Len() > limit[i] {
            maxTotalByActivatingOrders -= int64(heap.Pop(limitToValues[limit[i]]).(int))
        }
    }

    return maxTotalByActivatingOrders
}

type PriorityQueue []int

func (pq PriorityQueue) Len() int {
    return len(pq)
}

func (pq PriorityQueue) Less(first int, second int) bool {
    return pq[first] < pq[second]
}

func (pq PriorityQueue) Swap(first int, second int) {
    pq[first], pq[second] = pq[second], pq[first]
}

func (pq *PriorityQueue) Push(object any) {
    *pq = append(*pq, object.(int))
}

func (pq *PriorityQueue) Pop() any {
    value := (*pq)[pq.Len() - 1]
    *pq = (*pq)[0 : pq.Len() - 1]
    return value
}
