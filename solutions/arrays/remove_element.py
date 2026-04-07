from typing import List


def removeElement(nums: List[int], val: int) -> int:
    unique_pointer = 0

    for curr_pointer in range(len(nums)):
        if nums[curr_pointer] != val:
            nums[unique_pointer] = nums[curr_pointer]
            unique_pointer += 1

    return unique_pointer
