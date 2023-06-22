/**
 * Solution to the "Stand on Zanzibar" problem on Kattis.
 * @author Brendan Jones
 */
#include <iostream>
#include <vector>

void ProcessTestCase() {
    std::vector<int32_t> populations;

    int32_t value;
    while (std::cin >> value && value != 0) {
        populations.push_back(value);
    }

    int32_t numImports = 0;

    int32_t lastPopulation = 1;
    for (auto pop : populations) {

        // There were no changes in the population.
        if (pop == lastPopulation) {
            continue;
        }

        // The next largest native population is double.
        lastPopulation <<= 1;
        if (pop > lastPopulation) {
            numImports += pop - lastPopulation;
        }

        // Set the last population to the current population.
        lastPopulation = pop;
    }

    // Print the number of imports.
    std::cout << numImports << std::endl;
}

int main() {
    // Read the number of test cases.
    int32_t numTestCases;
    std::cin >> numTestCases;

    for (int32_t i = 0; i < numTestCases; ++i) {
        ProcessTestCase();
    }

    return 0;
}