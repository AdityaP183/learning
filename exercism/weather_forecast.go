package exercism

// CurrentCondition holds the latest reported weather condition
// (e.g., "sunny", "rainy", "cloudy").
var CurrentCondition string

// CurrentLocation holds the name of the city for which the
// current weather condition has been reported.
var CurrentLocation string

// Forecast updates the CurrentLocation and CurrentCondition
// based on the provided city and condition, and returns a
// formatted weather report string.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
