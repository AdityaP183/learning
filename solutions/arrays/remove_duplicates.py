from typing import List


def removeDuplicates(nums: List[int]) -> int:
    unique_pointer = 1
    curr_pointer = 1

    for num in nums:
        if curr_pointer == len(nums):
            break
        if nums[curr_pointer] != nums[curr_pointer - 1]:
            nums[unique_pointer] = nums[curr_pointer]
            unique_pointer += 1
        curr_pointer += 1

    return unique_pointer

def removeDuplicates_v1(nums: List[int]) -> int:
    unique_pointer = 1

    for curr_pointer in range(1,len(nums)):
        if curr_pointer == len(nums):
            break
        if nums[curr_pointer] != nums[curr_pointer - 1]:
            nums[unique_pointer] = nums[curr_pointer]
            unique_pointer += 1
        curr_pointer += 1

    return unique_pointer
