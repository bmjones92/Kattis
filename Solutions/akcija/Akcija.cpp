/**
 * Solution to the "Akcija" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <functional>
#include <iostream>

constexpr uint32_t MAX_BOOKS = 100000;
constexpr uint32_t GROUP_SIZE = 3;
constexpr uint32_t START_INDEX = GROUP_SIZE - 1;

int main() {
	uint32_t bookPrices[MAX_BOOKS];

	uint32_t numBooks = 0;
	std::cin >> numBooks;

	uint32_t totalCost = 0;

	for (uint32_t i = 0; i < numBooks; ++i) {
		std::cin >> bookPrices[i];
		totalCost += bookPrices[i];
	}
	std::sort(std::begin(bookPrices), std::begin(bookPrices) + numBooks, [](uint32_t a, uint32_t b) { return b < a; });

	for (uint32_t pos = START_INDEX; pos < numBooks; pos += GROUP_SIZE) {
		totalCost -= bookPrices[pos];
	}

	std::cout << totalCost;

	std::cin.get();
	std::cin.get();

	return 0;
}