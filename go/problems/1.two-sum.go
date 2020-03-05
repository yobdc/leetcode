package main

import (
	"fmt"
)

//1. 两数之和
func twoSum(nums []int, target int) []int {
	var result []int
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			if target == nums[i]+nums[j] {
				result = append(result, i, j)
				fmt.Println(result)
				return result
			}
		}
	}
	return result
}

// func main() {
// 	fmt.Println(twoSum([]int{2, 5, 5, 11}, 10))
// }
