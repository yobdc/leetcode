package main

import (
	"fmt"
)

//1013. 将数组分成和相等的三个部分
func canThreePartsEqualSum(A []int) bool {
	var left = A[0]
	var total int
	for i := 0; i < len(A); i++ {
		total += A[i]
	}
	if total%3 != 0 {
		return false
	}
	var part = total / 3

	for i := 0; i < len(A)-2; i++ {
		if i > 0 {
			left += A[i]
		}
		if part != left {
			continue
		}
		var middle = A[i+1]
		var right = total - left - middle
		for j := i + 1; j < len(A)-1; j++ {
			if j > i+1 {
				middle += A[j]
			}
			if j > i+1 {
				right -= A[j]
			}
			if left == middle && middle == right {
				fmt.Println(i, j, true)
				return true
			}
		}
	}

	fmt.Println(false)
	return false
}

// func main() {
// 	canThreePartsEqualSum([]int{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1})
// }
