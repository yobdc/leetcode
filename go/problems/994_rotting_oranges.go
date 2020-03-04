package main

import (
	"fmt"
)

//994.腐烂的橘子
func orangesRotting(grid [][]int) int {
	var startErr int = 2
	var infectedCount int = 1
	for infectedCount > 0 {
		infectedCount = 0
		for i := 0; i < len(grid); i++ {
			for j := 0; j < len(grid[i]); j++ {
				if grid[i][j] == startErr {
					if i-1 >= 0 && grid[i-1][j] == 1 {
						grid[i-1][j] = startErr + 1
						infectedCount++
					}
					if j-1 >= 0 && grid[i][j-1] == 1 {
						grid[i][j-1] = startErr + 1
						infectedCount++
					}
					if i+1 < len(grid) && grid[i+1][j] == 1 {
						grid[i+1][j] = startErr + 1
						infectedCount++
					}
					if j+1 < len(grid[i]) && grid[i][j+1] == 1 {
						grid[i][j+1] = startErr + 1
						infectedCount++
					}
				}
			}
		}
		if infectedCount > 0 {
			startErr++
			fmt.Println(grid)
		}
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				return -1
			}
		}
	}
	return startErr - 2
}
func main() {
	var input = [][]int{{0, 2}}
	fmt.Println(orangesRotting(input))
}
