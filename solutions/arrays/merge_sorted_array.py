from typing import List


def merge(nums1: List[int], m: int, nums2: List[int], n: int) -> None:
    """
    Do not return anything, modify nums1 in-place instead.
    """
    p_nums1 = m - 1
    p_nums2 = n - 1
    idx = m + n - 1

    while p_nums1 >= 0 and p_nums2 >= 0:
        if nums1[p_nums1] > nums2[p_nums2]:
            nums1[idx] = nums1[p_nums1]
            p_nums1 -= 1
        else:
            nums1[idx] = nums2[p_nums2]
            p_nums2 -= 1
        idx -= 1

    while p_nums2 >= 0:
            nums1[idx] = nums2[p_nums2]
            p_nums2 -= 1
            idx -= 1
