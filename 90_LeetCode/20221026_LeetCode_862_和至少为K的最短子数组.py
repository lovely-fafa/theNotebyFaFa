#!/usr/bin/python 3.10
# -*- coding: utf-8 -*- 
#
# @Time    : 2022-10-26 18:54
# @Author  : 发发
# @QQ      : 1315337973
# @File    : 20221026_LeetCode_和至少为K的最短子数组.py
# @Software: PyCharm

from collections import deque


class Solution:
    def shortestSubarray(self, nums: list[int], k: int) -> int:
        preSumArr = [0]
        res = len(nums) + 1
        for num in nums:
            preSumArr.append(preSumArr[-1] + num)
        q = deque()
        for i, curSum in enumerate(preSumArr):
            while q and curSum - preSumArr[q[0]] >= k:
                res = min(res, i - q.popleft())
            while q and preSumArr[q[-1]] >= curSum:
                q.pop()
            q.append(i)
        return res if res < len(nums) + 1 else -1


s = Solution()
print(s.shortestSubarray(nums=[2, -1, 2], k=3))
