/**
 * Solution to the "Modulo" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <unordered_set>

constexpr uint8_t MOD = 42;

int main() {
    auto remainders = std::unordered_set<uint8_t>();

    uint16_t number;
    for(uint8_t i = 0; i < 10; ++i) {
        std::cin >> number;

        remainders.insert(number % MOD);
    }

    std::cout << remainders.size();

    return 0;
}