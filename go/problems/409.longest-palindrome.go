package main

import (
	"fmt"
)

//409. 最长回文串
func longestPalindrome409(s string) int {
	var result = len(s)
	var chMap = make(map[byte]int)
	for i := 0; i < len(s); i++ {
		if _, ok := chMap[s[i]]; ok {
			chMap[s[i]] += 1
		} else {
			chMap[s[i]] = 1
		}
	}
	var oddCount int
	for _, val := range chMap {
		if val%2 == 1 {
			oddCount++
		}
	}
	if oddCount > 1 {
		result -= oddCount - 1
	}
	fmt.Println(result)
	return result
}

// func main() {
// 	longestPalindrome("abccccdd")
// }
