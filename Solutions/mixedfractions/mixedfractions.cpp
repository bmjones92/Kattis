/**
 * Solution to the "Mixed Fractions" problem on Reddit.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>

int main() {
    int32_t numerator;
    int32_t denominator;

    while ((std::cin >> numerator >> denominator) && (numerator != 0 || denominator != 0)) {
        std::cout << (numerator / denominator) << " " << (numerator % denominator) << " / " << denominator << std::endl;
    }
    return 0;
}