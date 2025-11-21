package main

func Solution(str string) []string {
	var chunks []string

	for i := 0; i < len(str); i += 2 {
		end := i + 2
		if end > len(str) {
			chunks = append(chunks, str[i:i+1]+"_")
		} else {
			chunks = append(chunks, str[i:end])
		}
	}

	return chunks
}
