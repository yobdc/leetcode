package main

import (
	"fmt"
)

//4. 寻找两个有序数组的中位数
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	var count = len(nums1) + len(nums2)
	var middleLeft int
	var middleRight int
	if count%2 == 0 {
		middleLeft = count / 2
		middleRight = middleLeft + 1
	} else {
		middleLeft = count/2 + 1
		middleRight = middleLeft
	}
	var i int
	var j int
	var nums = make([]int, 0)
	for i+j < middleRight {
		if i < len(nums1) && j < len(nums2) {
			if nums1[i] <= nums2[j] {
				nums = append(nums, nums1[i])
				i++
			} else {
				nums = append(nums, nums2[j])
				j++
			}
		} else if i >= len(nums1) && j < len(nums2) {
			nums = append(nums, nums2[j])
			j++
		} else if i < len(nums1) && j >= len(nums2) {
			nums = append(nums, nums1[i])
			i++
		}
	}
	var result = (float64(nums[middleLeft-1]) + float64(nums[middleRight-1])) / 2
	fmt.Println(result)
	return result
}

// func main() {
// 	findMedianSortedArrays([]int{1, 2}, []int{})
// }
