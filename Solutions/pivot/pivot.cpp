/**
 * Solution to the "Pivot" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>

int main() {
    // The number of elements in the array.
    uint32_t numElements;
    std::cin >> numElements;

    // The number of pivot points.
    uint32_t numPivots = 0;

    // The maximum number we've read in so far.
    uint32_t max = 0;

    // Read the elements in.
    uint32_t number;
    for (uint32_t i = 1; i <= numElements; ++i) {
        std::cin >> number;

        if (number > max) {
            max = number;
            if (number == i) {
                ++numPivots;
            }
        }
    }

    // Print the number of pivots that were found.
    std::cout << numPivots << std::endl;

    return 0;
}