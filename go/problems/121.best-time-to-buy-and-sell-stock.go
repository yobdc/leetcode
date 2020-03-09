package main

import (
	"fmt"
)

// 121. 买卖股票的最佳时机
func maxProfit(prices []int) int {
	var diff int
	for i := 0; i < len(prices)-1; i++ {
		for j := i + 1; j < len(prices); j++ {
			if prices[i] < prices[j] && diff < prices[j]-prices[i] {
				diff = prices[j] - prices[i]
			}
		}
	}
	fmt.Println(diff)
	return diff
}

// func main() {
// 	fmt.Println(maxProfit([]int{7, 6, 5, 5, 4, 3}))
// }
