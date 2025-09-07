
#include <queue>
#include <vector>
#include <numeric>
#include <unordered_map>
using namespace std;

class Solution {

public:
    long long maxTotal(vector<int>& value, vector<int>& limit) const {
        long long maxTotalByActivatingOrders = accumulate(value.begin(), value.end(), 0LL);
        unordered_map<int, priority_queue<int, vector<int>, greater<>>> limitToValues;

        for (int i = 0; i < limit.size(); ++i) {
            limitToValues[limit[i]].push(value[i]);

            if (limitToValues[limit[i]].size() > limit[i]) {
                maxTotalByActivatingOrders -= limitToValues[limit[i]].top();
                limitToValues[limit[i]].pop();
            }
        }

        return maxTotalByActivatingOrders;
    }
};
