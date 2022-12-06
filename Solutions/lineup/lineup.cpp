/**
 * Solution to the "Lineup" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <functional>
#include <iostream>
#include <string>
#include <vector>

int main() {
    std::vector<std::string> names;

    // The number of names in the list.
    uint32_t numNames;
    std::cin >> numNames;

    // Add the names to the vector.
    std::string name;
    for(uint32_t i = 0; i < numNames; ++i) {
        std::cin >> name;

        names.push_back(name);
    }

    // Determine the ordering of the names.
    if(std::is_sorted(names.begin(), names.end(), std::less<std::string>())) {
        std::cout << "INCREASING" << std::endl;
    } else if(std::is_sorted(names.begin(), names.end(), std::greater<std::string>())) {
        std::cout << "DECREASING" << std::endl;
    } else {
        std::cout << "NEITHER" << std::endl;
    }

    return 0;
}