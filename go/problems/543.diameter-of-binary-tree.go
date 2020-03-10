package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//543. 二叉树的直径
func diameterOfBinaryTree(root *TreeNode) int {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return 0
	}
	maxHeight, maxWidth := find(root, 0)
	fmt.Println(maxHeight, maxWidth)
	return maxWidth
}

func find(parent *TreeNode, max int) (maxHeight int, maxWidth int) {
	if parent == nil {
		return 0, 0
	}
	if parent.Left == nil && parent.Right == nil {
		return 1, 1
	}

	leftHeight, leftWidth := find(parent.Left, max)
	rightHeight, rightWidth := find(parent.Right, max)

	if leftHeight > rightHeight {
		maxHeight = leftHeight + 1
	} else {
		maxHeight = rightHeight + 1
	}
	maxWidth = leftHeight + rightHeight
	if leftWidth > maxWidth {
		maxWidth = leftWidth
	}
	if rightWidth > maxWidth {
		maxWidth = rightWidth
	}
	return
}

// func main() {
// 	var root = &TreeNode{
// 		1,
// 		&TreeNode{
// 			2,
// 			&TreeNode{
// 				4, nil, nil,
// 			},
// 			&TreeNode{
// 				5, nil, nil,
// 			},
// 		},
// 		&TreeNode{
// 			3, nil, nil,
// 		},
// 	}
// 	fmt.Println(diameterOfBinaryTree(root))
// }
