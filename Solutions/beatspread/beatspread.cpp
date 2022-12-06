/*
 * Solution to the "Beat the Spread!" problem on Kattis.*/

#include <algorithm>
#include <cstdint>
#include <iostream>

void ProcessTestCase() {
    int32_t sum;
    int32_t difference;

    std::cin >> sum >> difference;

    int32_t scoreA = (difference + sum) / 2;
    int32_t scoreB = (sum - scoreA);

    if (((sum + difference) % 2 != 0) || scoreA < 0 || scoreB < 0) {
        std::cout << "impossible" << std::endl;
    } else {
        std::cout << scoreA << " " << scoreB << std::endl;
    }
}

int main() {
    uint32_t numTestCases;
    std::cin >> numTestCases;

    for (uint32_t i = 0; i < numTestCases; ++i) {
        ProcessTestCase();
    }

    return 0;
}