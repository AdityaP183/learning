def isAnagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False

    alphabets = [0] * 26

    for letter in s:
        if letter.isalpha():
            idx = ord(letter) - 97
            alphabets[idx] += 1

    for letter in t:
        if letter.isalpha():
            idx = ord(letter) - 97
            alphabets[idx] -= 1

    return all(i == 0 for i in alphabets)


def isAnagramV2(s: str, t: str) -> bool:
    """
    Handles ASCII along with letters
    """

    if len(s) != len(t):
        return False

    items = [0] * 128

    for letter in s:
        items[ord(letter)] += 1

    for letter in t:
        items[ord(letter)] -= 1

    return all(i == 0 for i in items)


def isAnagramV3(s: str, t: str) -> bool:
    """
    Handles ASCII along with letters
    """

    if len(s) != len(t):
        return True

    items = [0] * 128

    for i in range(len(s)):
        items[ord(s[i])] += 1
        items[ord(t[i])] -= 1

    return all(i == 0 for i in items)
