#!/usr/bin/python 3.10
# -*- coding: utf-8 -*- 
#
# @Time    : 2023-07-20 15:39
# @Author  : 发发
# @QQ      : 1315337973
# @GitHub  : https://github.com/lovely-fafa
# @File    : 20230720_LeetCode_918_环形子数组的最大和.py
# @Software: PyCharm

from typing import List


class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        result = max(nums)
        pre = nums[0]

        for index, v in enumerate(nums):
            if index == 0:
                continue
            fi = max(v, pre + v)
            if fi >= result:
                result = fi
            pre = fi

        min_result = min(nums)
        pre = nums[0]
        for index, v in enumerate(nums):
            if index == 0:
                continue
            fi = min(v, pre + v)
            if fi < min_result:
                min_result = fi
            pre = fi

        return result if (result > (sum(nums) - min_result)) or (sum(nums) - min_result == 0) else sum(nums) - min_result


print(Solution().maxSubarraySumCircular([-3, -2, -3]))
