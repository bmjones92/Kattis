/**
 * Solution to the "Simon Says" problem on Kattis.
 */
#include <climits>
#include <cstdint>
#include <iostream>
#include <string>

const std::string COMMAND_STRING = "simon says";

int main() {
    int32_t numCommands = 0;
    std::cin >> numCommands;

    std::cin.ignore(INT_MAX, '\n');

    std::string command;
    for (int32_t i = 0; i < numCommands; ++i) {
        std::getline(std::cin, command);

        // The command should only print if "simon says" appears at the beginning.
        std::size_t pos = command.find(COMMAND_STRING);
        if (pos == 0 && command.length() > COMMAND_STRING.size() + 1) {
            std::cout << command.substr(COMMAND_STRING.size() + 1);
        }
        std::cout << std::endl;
    }
    return 0;
}