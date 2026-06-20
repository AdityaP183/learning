from typing import List


def searchInsert(nums: List[int], target: int) -> int:
    left_p = 0
    right_p = len(nums) - 1

    while left_p <= right_p:
        middle_p = (left_p + right_p) // 2

        if nums[middle_p] == target:
            return middle_p

        if target > nums[middle_p]:
            left_p = middle_p + 1
        else:
            right_p = middle_p - 1

    return left_p
