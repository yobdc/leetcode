package main

import (
	"fmt"
	"sort"
)

//面试题40. 最小的k个数
func getLeastNumbers(arr []int, k int) []int {
	sort.Ints(arr)
	var result = arr[0:k]
	fmt.Println(result)
	return result
}

// func main() {
// 	getLeastNumbers([]int{4, 5, 1, 6, 2, 7, 3, 8}, 4)
// }
