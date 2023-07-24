#!/usr/bin/python 3.10
# -*- coding: utf-8 -*- 
#
# @Time    : 2023-07-20 15:15
# @Author  : 发发
# @QQ      : 1315337973
# @GitHub  : https://github.com/lovely-fafa
# @File    : 20230720_LeetCode_53_最大子数组和.py
# @Software: PyCharm

from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        result = max(nums)
        pre = nums[0]
        for index, v in enumerate(nums):
            if index == 0:
                continue
            fi = max(v, pre + v)
            if fi >= result:
                result = fi
            pre = fi
        return result


print(Solution().maxSubArray([-1,-2]))
