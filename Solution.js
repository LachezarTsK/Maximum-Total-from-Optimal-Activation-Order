
// const {PriorityQueue} = require('@datastructures-js/priority-queue');
/*
 PriorityQueue is internally included in the solution file on leetcode.
 When running the code on leetcode it should stay commented out. 
 It is mentioned here just for information about the external library 
 that is applied for this data structure.
 */

/**
 * @param {number[]} value
 * @param {number[]} limit
 * @return {number}
 */
var maxTotal = function (value, limit) {
    let maxTotalByActivatingOrders = value.reduce((x, y) => x + y);
    const limitToValues = new Map();

    for (let i = 0; i < limit.length; ++i) {
        if (!limitToValues.has(limit[i])) {
            limitToValues.set(limit[i], new PriorityQueue((x, y) => x - y));
        }
        limitToValues.get(limit[i]).enqueue(value[i]);

        if (limitToValues.get(limit[i]).size() > limit[i]) {
            maxTotalByActivatingOrders -= limitToValues.get(limit[i]).dequeue();
        }
    }

    return maxTotalByActivatingOrders;
};
