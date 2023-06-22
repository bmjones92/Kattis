/**
 * Solution to the "Simon Says" problem on Kattis.
 */
#include <cstdint>
#include <iostream>
#include <string>

/**
 * Process a single test case.
 */
void ProcessCommand() {
    std::string line;
    std::getline(std::cin, line);

    if (line.find("Simon says") == 0) {
        std::cout << line.substr(11) << std::endl;
    }
}

int main() {
    uint32_t numCommands;
    std::cin >> numCommands;

    // Skip the remainder of the first line.
    std::cin.get();

    for (uint32_t i = 0; i < numCommands; ++i) {
        ProcessCommand();
    }
}