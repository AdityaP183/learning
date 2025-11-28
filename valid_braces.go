package main

func ValidBraces(str string) bool {
	stack := []rune{}
	pairs := map[rune]rune{
		')': '(',
		']': '[',
		'}': '{',
	}

	for _, brace := range str {
		if brace == '[' || brace == '{' || brace == '(' {
			stack = append(stack, brace)
		} else {
			if len(stack) == 0 {
				return false
			}

			top := stack[len(stack)-1]
			if pairs[brace] != top {
				return false
			}

			stack = stack[:len(stack)-1]
		}
	}

	return len(stack) == 0
}
