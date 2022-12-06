#include <cstdint>
#include <iostream>
#include <string>

void ProcessTestCase() {
    uint32_t numChildren;
    std::cin >> numChildren;

    uint64_t remainder = 0;
    for(uint32_t i = 0; i < numChildren; ++i) {
        uint64_t numCandies;
        std::cin >> numCandies;

        remainder += (numCandies % numChildren);
    }

    remainder %= numChildren;
    std::cout << ((remainder == 0) ? "YES" : "NO") << std::endl;
}

int main() {
    uint32_t numTestCases;
    std::cin >> numTestCases;

    for(uint32_t i = 0; i < numTestCases; ++i) {
        ProcessTestCase();
    }

    return 0;
}