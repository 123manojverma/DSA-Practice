#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    // Cycle Sort
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        int i = 0;

        while (i < n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }
            int index = nums[i] - 1;
            if (nums[i] != nums[index]) {
                swap(nums[i], nums[index]);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Using Boolean Array
    int firstMissingPositive1(vector<int>& nums) {
        int n = nums.size();
        vector<bool> seen(n, false);

        for (int num : nums) {
            if (num > 0 && num <= n) {
                seen[num - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return i + 1;
            }
        }

        return n + 1;
    }
};

int main(){
    vector<int>arr={1,2,0};
    Solution a;
    cout<<a.firstMissingPositive(arr);
}