package codewars


func MoveZeros(arr []int) []int {
	var sorted_arr []int
	var zeros_arr []int

	for _, num := range arr {
		if num == 0 {
			zeros_arr = append(zeros_arr, 0)
		} else {
			sorted_arr = append(sorted_arr, num)
		}
	}

	return append(sorted_arr, zeros_arr...)
}
