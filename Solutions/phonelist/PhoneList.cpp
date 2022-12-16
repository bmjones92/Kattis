/**
 * Solution for the "Phone List" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <climits>
#include <cstdint>
#include <iostream>
#include <string>
#include <vector>

void ProcessTestCase() {
	// The number of numbers to read in.
	uint32_t numNumbers;
	std::cin >> numNumbers;

	std::vector<std::string> phoneNumbers;

	// Populate the phone numbers with the input data.
	std::string number;
	for (uint32_t i = 0; i < numNumbers; ++i) {
		std::cin >> number;
		phoneNumbers.push_back(number);
	}
	std::sort(phoneNumbers.begin(), phoneNumbers.end());

	std::string prefix = "-";
	for (auto& num : phoneNumbers) {
		if (num.find(prefix) == 0) {
			// List is not consistent.
			std::cout << "NO" << std::endl;
			return;
		} else {
			// The current prefix is not a prefix of the current number,
			// so move the prefix ahead to the current element.
			prefix = num;
		}
	}

	// List is consistent.
	std::cout << "YES" << std::endl;
}

int main() {
	// The number of test cases to process.
	uint32_t numTestCases;
	std::cin >> numTestCases;

	for (uint32_t i = 0; i < numTestCases; ++i) {
		ProcessTestCase();
	}

	return 0;
}
