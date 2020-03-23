package main

import (
// "fmt"
)

type ListNode876 struct {
	Val  int
	Next *ListNode876
}

//876. 链表的中间结点
func middleNode(head *ListNode876) *ListNode876 {
	var middle *ListNode876 = head
	var tail *ListNode876 = head
	if tail != nil {
		tail = tail.Next
	}
	for tail != nil {
		middle = middle.Next
		tail = tail.Next
		if tail != nil {
			tail = tail.Next
		}
	}
	// fmt.Println(*middle)
	return middle
}

// func main() {
// 	middleNode(nil)
// }
