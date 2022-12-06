/**
 * Solution to the "Erase Securely" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <string>

int main() {
    int32_t numFlips;
    std::cin >> numFlips;

    std::string initialLine;
    std::getline(std::cin, initialLine);
    std::getline(std::cin, initialLine);

    if(numFlips % 2) {
        // The bits should be flipped.
        char ch;
        for(uint32_t i = 0; i < initialLine.length() && std::cin >> ch; ++i) {
            if(initialLine[i] == ch) {
                std::cout << "Deletion failed" << std::endl;
                return 0;
            }
        }
    } else {
        // The bits should be the same.
        char ch;
        for(uint32_t i = 0; i < initialLine.length() && std::cin >> ch; ++i) {
            if(initialLine[i] != ch) {
                std::cout << "Deletion failed" << std::endl;
                return 0;
            }
        }
    }

    std::cout << "Deletion succeeded" << std::endl;
    return 0;
}