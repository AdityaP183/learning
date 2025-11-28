package main

import "fmt"

func main() {
	res := ValidBraces("(){}[]")
	res1 := ValidBraces("([{}])")
	res2 := ValidBraces("(}")
	res3 := ValidBraces("[(])")
	res4 := ValidBraces("[({})](]")

	fmt.Println(res)
	fmt.Println(res1)
	fmt.Println(res2)
	fmt.Println(res3)
	fmt.Println(res4)
}
