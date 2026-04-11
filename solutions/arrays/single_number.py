from typing import List


def singleNumber(nums: List[int]) -> int:
    unique_el = []

    for num in nums:
        if num in unique_el:
            unique_el.remove(num)
        else:
            unique_el.append(num)

    return unique_el[0]

def singleNumberV2(nums: List[int]) -> int:
    res = 0

    for num in nums:
        res ^= num

    return res
