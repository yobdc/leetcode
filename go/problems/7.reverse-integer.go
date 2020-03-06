package main

import (
	"fmt"
	"strconv"
)

//7. 整数反转
func reverse(x int) int {
	var resultStr string
	var str = strconv.Itoa(x)
	for i := len(str) - 1; i >= 0; i-- {
		if str[i] != '-' {
			resultStr += string(str[i])
		}
	}
	if x < 0 {
		resultStr = "-" + resultStr
	}
	var result, err = strconv.ParseInt(resultStr, 10, 32)
	fmt.Println(err)
	if err != nil {
		return 0
	} else {
		return int(result)
	}
}

// func main() {
// 	fmt.Println(reverse(-233))
// }
