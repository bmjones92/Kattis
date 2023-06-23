/**
 * Solution to the "Tri" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <iostream>

/**
 * Find which operator to apply to `a` and `b` to produce `result`.
 */
char FindSolution(uint32_t a, uint32_t b, uint32_t result) {
    if (a + b == result) {
        return '+';
    }
    if (a - b == result) {
        return '-';
    }
    if (b != 0 && a / b == result) {
        return '/';
    }
    if (a * b == result) {
        return '*';
    }

    return '\0';
}

int main() {
    uint32_t numA;
    uint32_t numB;
    uint32_t numC;

    std::cin >> numA >> numB >> numC;

    char solution = FindSolution(numA, numB, numC);
    if (solution == '\0') {
        solution = FindSolution(numB, numC, numA);
        std::cout << numA << "=" << numB << solution << numC;
    }
    else {
        std::cout << numA << solution << numB << "=" << numC;
    }
    std::cout << std::endl;

    return 0;
}