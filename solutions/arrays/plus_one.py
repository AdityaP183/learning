from typing import List


def plusOne(digits: List[int]) -> List[int]:
    num_str = ""

    for n in digits:
        num_str += str(n)

    res = int(num_str) + 1

    return [int(num) for num in str(res)]

def plusOneV2(digits: List[int]) -> List[int]:
    size = len(digits) - 1

    for idx in range(size, -1, -1):
        if digits[idx] < 9:
            digits[idx] += 1
            return digits
        digits[idx] = 0
    return [1] + digits
