/**
 * Solution to the "Ragged Right" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <string>
#include <vector>

int main() {
    std::vector<std::string> lines;

    uint32_t longest = 0;
    
    // Read the lines into the vector and find the longest.
    std::string line;
    while (std::getline(std::cin, line)) {
        lines.push_back(line);
        if (line.length() > longest) {
            longest = line.length();
        }
    }

    // Calculate the raggedness factor.
    uint32_t factor = 0;
    for (auto iter = lines.cbegin(); iter != lines.cend() - 1; ++iter) {
        // Calculate the factor and move to the next element.
        uint32_t delta = longest - iter->length();
        factor += (delta * delta);
    }

    // Print the factor.
    std::cout << factor;

    return 0;
}