package codewars

import (
	"strings"
)

func ReverseWord(word string) string {
    runes := []rune(word)
    for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
        runes[i], runes[j] = runes[j], runes[i]
    }
    return string(runes)
}

func SpinWords(str string) string {
	words := strings.Split(str, " ")

	processed_str := ""

	for i, word := range words {
		if len(word) >= 5{
			processed_str += ReverseWord(word)
		}else{
			processed_str += word
		}

		if i < len(words)-1{
			processed_str += " "
		}
	}

	return processed_str
}
