from typing import List


def longestCommonPrefix(strs: List[str]) -> str:
    if not strs:
        return ""

    prefixs = ""

    for a in strs[0]:
        checker = prefixs + a
        res = [letter.startswith(checker) for letter in strs]

        if False in res:
            break

        prefixs += a

    return prefixs
