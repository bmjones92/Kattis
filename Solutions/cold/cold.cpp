/**
 * Solution to the "Cold-puter Science" problem on Kattis.
 * @author Brendan Jones
 */
#include <iostream>
#include <cstdint>

int main() {
    uint32_t count = 0;
    std::cin >> count;

    uint32_t numNegative = 0;
    int32_t temp = 0;
    for (int i = 0; i < count; ++i) {
        std::cin >> temp;
        if(temp < 0) {
            ++numNegative;
        }
    }

    std::cout << numNegative;
    return 0;
}