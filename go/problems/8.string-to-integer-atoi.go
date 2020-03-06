package main

import (
	"fmt"
	"math"
)

//8. 字符串转换整数 (atoi)
func myAtoi(str string) int {
	var result int64
	var signal bool
	var head bool
	var headChar byte
	for i := 0; i < len(str); i++ {
		if str[i] == ' ' && (!head || str[i-1] == ' ') {
			if signal || result > 0 || headChar > 0 {
				break
			}
			head = true
			continue
		} else if !signal && (str[i] == '-' || str[i] == '+') {
			if headChar == 0 {
				headChar = str[i]
			} else {
				break
			}
			signal = true
		} else if str[i] >= '0' && str[i] <= '9' {
			if headChar == 0 {
				headChar = str[i]
			}
			result = result*10 + int64(str[i]-'0')
			if result > math.MaxInt32 {
				result = math.MaxInt32 + 1
				break
			}
		} else {
			break
		}
	}
	if signal && headChar == '-' {
		result = -result
	}
	if result < math.MinInt32 {
		result = math.MinInt32
	} else if result > math.MaxInt32 {
		result = math.MaxInt32
	}
	fmt.Println(result)
	return int(result)
}

func main() {
	fmt.Print(myAtoi("  -10 ss-331"))
}
