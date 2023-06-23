/**
 * Solution to the "Dragon of Loowater" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <iostream>
#include <set>
#include <vector>

/**
 * Process a single test case.
 * @param numHeads The number of heads.
 * @param numKnights The number of knights.
 */
void ProcessTestCase(uint32_t numHeads, uint32_t numKnights) {
    std::vector<uint32_t> heads;
    for (uint32_t i = 0; i < numHeads; ++i) {
        uint32_t value;
        std::cin >> value;

        heads.push_back(value);
    }

    std::multiset<uint32_t> knights;
    for (uint32_t i = 0; i < numKnights; ++i) {
        uint32_t value;
        std::cin >> value;

        knights.insert(value);
    }

    uint32_t totalCost = 0;
    for (uint32_t head : heads) {
        auto iter = knights.lower_bound(head);
        if (iter == knights.end()) {
            std::cout << "Loowater is doomed!" << std::endl;
            return;
        }

        totalCost += *iter;

        knights.erase(iter);
    }

    std::cout << totalCost << std::endl;
}

int main() {
    uint32_t numHeads;
    uint32_t numKnights;
    while (std::cin >> numHeads >> numKnights && numHeads != 0 && numKnights != 0) {
        ProcessTestCase(numHeads, numKnights);
    }
    return 0;
}
