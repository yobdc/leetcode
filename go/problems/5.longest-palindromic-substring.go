package main

import (
	"fmt"
	"math"
)

//5. 最长回文子串
func longestPalindrome(s string) string {
	var result string
	var maxLen int
	var mid = 0.0
	for mid <= float64(len(s)-1) {
		var midLeft = int(math.Floor(mid))
		var midRight = int(math.Ceil(mid))
		var tmpMax = 0
		var i = 0
		for i = 0; midLeft-i >= 0 && midRight+i < len(s); i++ {
			if s[midLeft-i] == s[midRight+i] {
				if midLeft-i == midRight+i {
					tmpMax = 1
				} else {
					tmpMax = midRight + i - midLeft + i + 1
				}
			} else {
				break
			}
		}
		if tmpMax > maxLen {
			result = s[midLeft-i+1 : midRight+i]
			maxLen = tmpMax
		}
		mid += 0.5
	}
	fmt.Println(result)
	return result
}

// func main() {
// 	longestPalindrome("12343")
// }
