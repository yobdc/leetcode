package main

import (
	"fmt"
	"strconv"
)

//9. 回文数
func isPalindrome(x int) bool {
	var str = strconv.Itoa(x)
	for i, j := 0, len(str)-1; i < j; i, j = i+1, j-1 {
		if str[i] != str[j] {
			return false
		}
	}
	fmt.Println(true)
	return true
}

// func main() {
// 	fmt.Println(isPalindrome(+101))
// }
