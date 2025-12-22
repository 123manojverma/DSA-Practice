#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> majorityElement(vector<int> &nums)
    {
        int n = nums.size();
        int cnt1 = 0;
        int cnt2 = 0;
        int val1 = INT_MIN;
        int val2 = INT_MIN;
        int i = 0;
        while (i < n)
        {
            if (nums[i] == val1)
            {
                cnt1++;
            }
            else if (nums[i] == val2)
            {
                cnt2++;
            }
            else if (cnt1 == 0)
            {
                val1 = nums[i];
                cnt1 = 1;
            }
            else if (cnt2 == 0)
            {
                val2 = nums[i];
                cnt2 = 1;
            }
            else
            {
                cnt1--;
                cnt2--;
            }

            i++;
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] == val1)
                cnt1++;
            if (nums[i] == val2)
                cnt2++;
        }
        vector<int> ans;
        if (cnt1 > n / 3)
        {
            ans.push_back(val1);
        }
        if (cnt2 > n / 3)
        {
            ans.push_back(val2);
        }
        return ans;
    }
};