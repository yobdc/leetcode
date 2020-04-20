package main

import (
	"fmt"
)

//3. 无重复字符的最长子串
func lengthOfLongestSubstring(s string) int {
	var result int
	var strMap = make(map[byte]int)
	var start = 0
	var end = 0
	for start = 0; start < len(s); {
		var maxResult = 0
		for end = start; end < len(s); end++ {
			if index, ok := strMap[s[end]]; ok {
				start = index + 1
				strMap = make(map[byte]int)
				break
			} else {
				strMap[s[end]] = end
				maxResult++
			}
		}
		if maxResult > result {
			result = maxResult
		}
		if end == len(s)-1 {
			break
		}
	}
	fmt.Println(result)
	return result
}

// func main() {
// 	lengthOfLongestSubstring("1")
// }
