package main

import (
	"fmt"
)

type ListNode2 struct {
	Val  int
	Next *ListNode2
}

// 2. 两数相加
func addTwoNumbers(l1 *ListNode2, l2 *ListNode2) *ListNode2 {
	var current = &ListNode2{}
	var result *ListNode2 = current
	var tmp1 = l1
	var tmp2 = l2
	var more int
	for tmp1 != nil || tmp2 != nil || more > 0 {
		var sum = more
		more = 0
		if tmp1 != nil {
			sum += tmp1.Val
			tmp1 = tmp1.Next
		}
		if tmp2 != nil {
			sum += tmp2.Val
			tmp2 = tmp2.Next
		}
		current.Val = sum % 10
		if sum >= 10 {
			more = 1
		}
		if tmp1 != nil || tmp2 != nil || more > 0 {
			current.Next = &ListNode2{}
			current = current.Next
		}
	}
	fmt.Print(result)
	return result
}

// func main() {
// 	var start = addTwoNumbers(&ListNode{
// 		2, &ListNode{
// 			4, &ListNode{
// 				3, nil,
// 			},
// 		},
// 	}, &ListNode{
// 		5, &ListNode{
// 			6, &ListNode{
// 				4, &ListNode{
// 					4, nil,
// 				},
// 			},
// 		},
// 	})
// 	for start != nil {
// 		fmt.Print(start.Val)
// 		start = start.Next
// 	}
// }
