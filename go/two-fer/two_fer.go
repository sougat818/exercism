// Package twofer creates simple sentences
package twofer

import "fmt"

// ShareWith returns a sentence of the form "One for X, one for me."
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}

	return fmt.Sprintf("One for %s, one for me.", name)
}
