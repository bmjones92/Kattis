/**
 * Solution to the "Secure Doors" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <map>
#include <string>

int main() {
    std::map<std::string, bool> isInBuilding;

    // The number of events to read in.
    uint32_t numEvents = 0;
    std::cin >> numEvents;

    std::string state;
    std::string name;
    for (uint32_t i = 0; i < numEvents; ++i) {
        // Read a line of input in.
        std::cin >> state >> name;

        // Grab the old and new states.
        bool newState = (state == "entry");
        bool oldState = isInBuilding[name];

        // Print {Name} {Entered/Exited}
        std::cout << name << ((newState) ? " entered" : " exited");

        // If the old and new states are the same,
        if (newState == oldState) {
            std::cout << " (ANOMALY)";
        } else {
            isInBuilding[name] = newState;
        }
        std::cout << std::endl;
    }

    return 0;
}