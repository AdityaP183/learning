package main

import (
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func HighAndLow(in string) string {
	str_nums := strings.Split(in, " ")
	var int_nums []int

	for _, num := range str_nums {
		n, err := strconv.Atoi(num)
		if err != nil {
			fmt.Println(err)
			os.Exit(2)
			continue
		}
		int_nums = append(int_nums, n)
	}

	sort.Ints(int_nums)

	res := fmt.Sprintf("%d %d", int_nums[len(int_nums)-1], int_nums[0])

	return res
}
