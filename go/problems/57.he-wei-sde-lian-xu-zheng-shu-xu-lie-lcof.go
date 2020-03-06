package main

import (
	"fmt"
)

//57 - II. 和为s的连续正数序列
func findContinuousSequence(target int) [][]int {
	var result [][]int
	var start = 1
	for start < target/2+2 {
		var sum = 0
		var seq []int
		for current := start; current < target/2+2; current++ {
			sum += current
			seq = append(seq, current)
			if sum == target {
				result = append(result, seq)
				break
			} else if sum > target {
				break
			}
		}
		start++
	}
	fmt.Println(result)
	return result
}

// func main() {
// 	fmt.Println(findContinuousSequence(15))
// }
