/**
 * Solution to the "Quick Brown Fox" problem on Kattis.
 * @author Brendan Jones
 */
#include <bitset>
#include <cctype>
#include <cstdint>
#include <iostream>
#include <string>

const int32_t NUM_BITS = 26;

void ProcessTestCase() {
    // 0 = missing; 1 = found
    std::bitset<NUM_BITS> letters; 

    std::string line;
    std::getline(std::cin, line);

    for (char ch : line) {
        if (std::isalpha(ch)) {
            ch = std::tolower(ch);
            // Character has been found
            letters[ch - 'a'] = true; 
        }
    }

    if (letters.all()) {
        // All bits are set, so we have a pangram.
        std::cout << "pangram" << std::endl;
    } else {
        // Some bits are not set, so we must print them out.
        std::cout << "missing ";
        for (int32_t i = 0; i < NUM_BITS; ++i) {
            if (!letters[i]) {
                // Print the missing character.
                std::cout << static_cast<char>('a' + i);
            }
        }
        std::cout << std::endl;
    }
}

int main() {
    // Read the number of test cases.
    int32_t numTestCases;
    std::cin >> numTestCases;

    std::cin.get();

    for (int32_t i = 0; i < numTestCases; ++i) {
        ProcessTestCase();
    }
    return 0;
}