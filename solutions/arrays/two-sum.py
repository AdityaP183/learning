from typing import List


def twoSum(self, nums: List[int], target: int):
    history = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in history:
            return [history[complement], i]
        history[num] = i
