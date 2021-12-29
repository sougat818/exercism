package cars

const productionRate = 221.0

// SuccessRate is used to calculate the ratio of an item being created without
// error for a given speed
// 0: 0% success rate.
// 1 - 4: 100% success rate.
// 5 - 8: 90% success rate.
// 9 - 10: 77% success rate.
func SuccessRate(speed int) float64 {
	switch speed {
	case 0:
		return 0.0
	case 1, 2, 3, 4:
		return 1.0
	case 5, 6, 7, 8:
		return .9
	case 9, 10:
		return .77
	default:
		return 0.0
	}
}

// CalculateProductionRatePerHour for the assembly line, taking into account
// its success rate
func CalculateProductionRatePerHour(speed int) float64 {
	return SuccessRate(speed) * float64(speed) * productionRate
}

// CalculateProductionRatePerMinute describes how many working items are
// produced by the assembly line every minute
func CalculateProductionRatePerMinute(speed int) int {
	return int(CalculateProductionRatePerHour(speed)) / 60
}

// CalculateLimitedProductionRatePerHour describes how many working items are
// produced per hour with an upper limit on how many can be produced per hour
func CalculateLimitedProductionRatePerHour(speed int, limit float64) float64 {
	return min(CalculateProductionRatePerHour(speed), limit)
}

func min(first float64, second float64) float64 {
	if first < second {
		return first
	}
	return second
}
