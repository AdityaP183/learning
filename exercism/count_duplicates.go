package exercism

import (
	"strings"
)

func Duplicate_count(s1 string) int {
	str := strings.ToLower(s1)

	counts := make(map[rune]int)

	for _, char := range str {
		counts[char]++
	}

	duplicates := 0
	for _, count := range counts {
		if count > 1 {
			duplicates++
		}
	}

	return duplicates
}
