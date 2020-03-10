package main

import (
	"fmt"
	"strconv"
)

//43. 字符串相乘
func multiply(num1 string, num2 string) string {
	if num1 == "0" || num2 == "0" {
		return "0"
	}
	var len1 = len(num1)
	var len2 = len(num2)
	var result string
	var plus bool
	for i := len1 - 1; i >= 0; i-- {
		var tmp int
		var plusNum int
		var tmpResult string
		for j := len2 - 1; j >= 0; j-- {
			var n1 = int(num1[i] - '0')
			var n2 = int(num2[j] - '0')
			tmp = n1 * n2
			if plus {
				tmp += plusNum
				plus = false
				plusNum = 0
			}
			if tmp > 9 {
				plus = true
				plusNum = tmp / 10
				tmp = tmp % 10
			}
			tmpResult = strconv.Itoa(tmp) + tmpResult
		}
		if plus {
			tmpResult = strconv.Itoa(plusNum) + tmpResult
			plus = false
			plusNum = 0
		}
		for k := 0; k < len1-1-i; k++ {
			tmpResult = tmpResult + "0"
		}
		result = add(result, tmpResult)
	}
	if plus {
		result = "1" + result
		plus = false
	}
	fmt.Println(result)
	return result
}

func add(num1 string, num2 string) string {
	if num1 == "" {
		num1 = "0"
	}
	if num2 == "" {
		num2 = "0"
	}
	var result string
	var iFinished bool
	var jFinished bool
	var plus bool
	var i = len(num1) - 1
	var j = len(num2) - 1
	for i >= 0 || j >= 0 {
		var tmp = 0
		if i >= 0 && !iFinished {
			tmp += int(num1[i] - '0')
			i--
		}
		if j >= 0 && !jFinished {
			tmp += int(num2[j] - '0')
			j--
		}
		if plus {
			tmp += 1
			plus = false
		}
		if tmp > 9 {
			plus = true
			tmp = tmp % 10
		}
		result = strconv.Itoa(tmp) + result
	}
	if plus {
		result = "1" + result
		plus = false
	}

	return result
}

// func main() {
// 	multiply("9", "99")
// }
