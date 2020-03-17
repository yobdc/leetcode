package main

import (
	"fmt"
)

//1160. 拼写单词
func countCharacters(words []string, chars string) int {
	var result int
	var vol = make(map[byte]int)
	for i := 0; i < len(chars); i++ {
		if _, ok := vol[chars[i]]; ok {
			vol[chars[i]] += 1
		} else {
			vol[chars[i]] = 1
		}
	}
	for i := 0; i < len(words); i++ {
		var wordMap = copyMap(vol)
		var match = true
		for j := 0; j < len(words[i]); j++ {
			if _, ok := wordMap[words[i][j]]; ok && wordMap[words[i][j]] > 0 {
				wordMap[words[i][j]] -= 1
			} else {
				match = false
				break
			}
		}
		if match {
			result += len(words[i])
		}
	}
	fmt.Println(result)
	return result
}

func copyMap(src map[byte]int) map[byte]int {
	dest := make(map[byte]int)
	for k2, v2 := range src {
		dest[k2] = v2
	}
	return dest
}

// func main() {
// 	countCharacters([]string{"cat", "bt", "hat", "tree"}, "atach")
// }
