/**
 * Solution to the "Aaah" problem on Kattis.
 * @author Brendan Jones
 */
#include <iostream>
#include <string>

int main() {
    std::string input[2];
    for (auto& line : input) {
        std::getline(std::cin, line);
    }

    std::cout << ((input[0].size() >= input[1].size()) ? "go" : "no");

    return 0;
}