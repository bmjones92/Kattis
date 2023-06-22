/**
 * Solution to the "Planting Trees" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <iostream>

int main() {
    uint32_t numTrees;
    std::cin >> numTrees;

    uint32_t* pTrees = new uint32_t[numTrees];
    for (uint32_t i = 0; i < numTrees; ++i) {
        std::cin >> pTrees[i];
    }

    std::sort(pTrees, pTrees + numTrees, [](uint32_t a, uint32_t b) {
        return a > b;
    });

    uint32_t longestTime = 0;
    for (uint32_t i = 0; i < numTrees; ++i) {
        uint32_t time = pTrees[i] + i + 1;
        if (time > longestTime) {
            longestTime = time;
        }
    }

    std::cout << (longestTime + 1) << std::endl;
}
