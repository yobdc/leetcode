package main

import (
	"fmt"
	"math"
)

//29. 两数相除
func divide(dividend int, divisor int) int {
	if dividend == 0 {
		return 0
	}
	var count = 0
	var signal = false
	if (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) {
		signal = true
	}
	var dividend2 = dividend
	if dividend2 < 0 {
		dividend2 = -dividend2
	}
	var divisor2 = divisor
	if divisor2 < 0 {
		divisor2 = -divisor2
	}
	var sum = divisor2
	for sum <= dividend2 {
		if sum+sum <= dividend2 {
			sum += sum
			if count == 0 {
				count = 2
			} else {
				count += count
			}
		} else {
			sum += divisor2
			count++
		}
	}

	if count > 1 {
		count--
	}
	if signal {
		count = -count
	}
	if count > math.MaxInt32 || count < math.MinInt32 {
		return math.MaxInt32
	}
	fmt.Println(count)
	return count
}

// func main() {
// 	fmt.Print(divide(6, 3))
// }
