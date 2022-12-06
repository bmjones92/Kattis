/**
 * Solution for the "CD" problem on Kattis.
 * @author Brendan Jones
 */

#include <cstdint>
#include <iostream>

/**
 * Calculate the index of the cd.
 */
inline uint32_t Index(uint32_t cd) {
	return (cd >> 3);
}

/**
 * Calculates the bitmask of the cd.
 */
inline uint8_t Mask(uint32_t cd) {
	return (1 << (cd % 8));
}

/**
 * Processes a single test case.
 */
bool ProcessTestCase() {
	uint32_t numJack;
	uint32_t numJill;

	std::cin >> numJack >> numJill;
    
    // "0 0" indicates the end of the input.
	if (numJack == 0 && numJill == 0) {
		return false;
	}

	// Each CD is stored as an individual bit within the catalog.
	uint8_t catalog[125000000] = {};

    // Read the CDs owned by Jack and set the corresponding bit in the catalog.
	uint32_t cd;
	for (uint32_t i = 0; i < numJack; ++i) {
		std::cin >> cd;
        
        // Set the corresponding bit for the CD.
		catalog[Index(cd)] |= Mask(cd);
	}

    // Read the CDs owned by Jill.
	uint32_t numSold = 0;
	for (uint32_t i = 0; i < numJill; ++i) {
		std::cin >> cd;
        
        // Increment the number of books sold if both Jack and Jill own the CD.
		numSold += (catalog[Index(cd)] & Mask(cd)) != 0;
	}

    // Print the total number of sales.
	std::cout << numSold << std::endl;

    // Indicate that there's another test case to process.
	return true;
}

int main() {
	while (ProcessTestCase());
	return 0;
}
