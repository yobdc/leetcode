package main

import (
	"fmt"
)

//1103. 分糖果 II
func distributeCandies(candies int, num_people int) []int {
	var result = make([]int, num_people)
	var nextCandies = 1
	var index = 0
	for candies > 0 {
		if candies-nextCandies > 0 {
			result[index] += nextCandies
			candies -= nextCandies
		} else {
			result[index] += candies
			break
		}

		nextCandies++
		index = (index + 1) % num_people
	}
	return result
}

func main() {
	fmt.Println(distributeCandies(10, 3))
}
