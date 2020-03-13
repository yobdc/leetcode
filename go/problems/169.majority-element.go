package main

import (
	"fmt"
)

//169. 多数元素
func majorityElement(nums []int) int {
	var halfCount = len(nums) / 2
	var numMap = make(map[int]int)
	for i := 0; i < len(nums); i++ {
		numMap[nums[i]] += 1
		if numMap[nums[i]] > halfCount {
			fmt.Println(nums[i], numMap[nums[i]], "in", len(nums))
			return nums[i]
		}
	}
	return 0
}

// func main() {
// 	majorityElement([]int{2, 2, 1, 1, 1, 2, 2})
// }
