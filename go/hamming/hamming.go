package hamming

import (
	"errors"
	"unicode/utf8"
)

// Distance calculates the Hamming distance between a & b
func Distance(a, b string) (int, error) {
	if utf8.RuneCountInString(a) != utf8.RuneCountInString(b) {
		return 0, errors.New("hamming distance is only defined for sequences of equal length")
	}
	aRune := []rune(a)
	bRune := []rune(b)

	distance := 0
	for i := range aRune {
		if aRune[i] != bRune[i] {
			distance++
		}
	}
	return distance, nil
}
