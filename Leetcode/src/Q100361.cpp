//
// Created by Administrator on 19/7/2024.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
using namespace std;

class Solution {
public:
    long long minimumCost(int m, int n, vector<int>& horizontalCut, vector<int>& verticalCut) {
        long sum = accumulate(verticalCut.begin(), verticalCut.end(), 0);
        sum += accumulate(horizontalCut.begin(), horizontalCut.end(), 0);

        sort(horizontalCut.begin(), horizontalCut.end());
        sort(verticalCut.begin(), verticalCut.end());
        int i = 0, j = 0;
        while (i <= m - 2 && j <= n - 2) {
            if (horizontalCut[m - 2 - i] <= verticalCut[n - 2 - j]) {
                sum += verticalCut[n - 2 - j] * i;
                ++j;
            } else {
                sum += horizontalCut[m - 2 - i] * j;
                ++i;
            }
        }
        while (i <= m - 2) {
            sum += horizontalCut[m - 2 - i] * j;
            ++i;
        }
        while (j <= n - 2) {
            sum += verticalCut[n - 2 - j] * i;
            ++j;
        }
        return sum;
    }
};

int main() {
    Solution s;
    vector<int> horizontalCut = {1, 2, 3, 4, 5};  // 假设有5个水平切割
    vector<int> verticalCut = {1, 2};  // 假设有2个垂直切割

    // 调用minimumCost函数并输出结果
    cout << "Minimum cost: " << s.minimumCost(6, 3, horizontalCut, verticalCut) << endl;

    return 0;
}