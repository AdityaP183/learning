package exercism

import (
	"fmt"
	"strings"
)

func WelcomeMessage(customer string) string {
	return fmt.Sprintf("Welcome to the Tech Palace, %s", strings.ToUpper(customer))
}

// AddBorder adds a border to a welcome message.
func AddBorder(welcomeMsg string, numStarsPerLine int) string {
	stars := strings.Repeat("*", numStarsPerLine)

	return stars + "\n" + welcomeMsg + "\n" + stars
}

// CleanupMessage cleans up an old marketing message.
func CleanupMessage(oldMsg string) string {
	lines := strings.SplitSeq(oldMsg, "\n")
	for line := range lines {
		trimmed := strings.Trim(line, " *")
		if len(trimmed) > 0 {
			return trimmed
		}
	}
	return ""
}
